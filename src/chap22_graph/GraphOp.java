package chap22_graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2018/5/8.
 * 图的相关操作，图的遍历
 */
public class GraphOp {

    public static void main(String[] args) {
        int v=4,e=5;
        Graph graph = new Graph(v);
       int []fromIndex = {0,0,1,3,3};
       int []endIndex ={1,2,3,2,0};
       int []weight = {1,2,3,4,5};
       String[]name = {"a","b","c","d"};
       for(int i = 0;i<e;i++) graph.addEdge(fromIndex[i],endIndex[i],weight[i]);
       System.out.println("图的邻接表存储情况:");
       System.out.println(graph);
        System.out.println("图的深度搜索结果：");
       DFS(graph,0);
        System.out.println("\n图的广度搜索结果：");
        BFS(graph,0);
    }

    public static  void DFS(Graph g,int fromIndex)
    {
        VertexNode node = g.vertexNodes.get(fromIndex);
        g.ResetVisit();
        g.visit[fromIndex] = true;
       DFSVisit(g,node);

    }

    public static void DFSVisit(Graph g, VertexNode v)
    {
        System.out.print(v.index+"\t");
        for (EdgeNode e:v.arcs)
        {
            VertexNode nextNode = g.vertexNodes.get(e.endIndex);
            if(!g.visit[nextNode.index])
            {
                g.visit[nextNode.index]=true;
                DFSVisit(g,nextNode);
            }
        }

    }
    public static void BFS(Graph g, int fromIndex)
    {
        VertexNode node = g.vertexNodes.get(fromIndex);
        List<VertexNode> queue = new ArrayList<>();
        boolean []visit = new boolean[g.vertexCount];
        for (boolean i :visit) i = false;
        queue.add(node);
        visit[node.index] = true;
        g.ResetVisit();
        while (queue.size()>0)
        {
            node = queue.get(0);
            System.out.print(node.index+"\t");
            queue.remove(node);
            for(EdgeNode edgeNode :node.arcs){
                VertexNode v = g.vertexNodes.get(edgeNode.endIndex);
                if(!visit[v.index])
                {
                    queue.add(v);
                    visit[v.index] = true;
                }
            }
        }
    }
}
