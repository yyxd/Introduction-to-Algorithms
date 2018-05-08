package chap22_graph;


import java.util.*;

/**
 * Created by HinTi on 2018/5/8.
 * 最小生成树
 */
public class MST {

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0,1,4);
        graph.addEdge(0,7,8);
        graph.addEdge(1,2,8);
        graph.addEdge(1,7,7);
        graph.addEdge(2,3,7);
        graph.addEdge(2,5,4);
        graph.addEdge(2,8,2);
        graph.addEdge(3,4,9);
        graph.addEdge(3,5,14);
        graph.addEdge(4,5,10);
        graph.addEdge(5,6,2);
        graph.addEdge(6,7,1);
        graph.addEdge(6,8,6);
        graph.addEdge(7,8,7);
        Kruskal(graph);
    }

    public static void Kruskal(Graph graph)
    {
        int countWeight = 0;
        Set<Set<Integer>> treeVertexs = new HashSet<>();//最小生成树的节点
        List<EdgeNode> treeEdges = new ArrayList<>();//最小生成树的边
        List<EdgeNode> edges = new ArrayList<>();
        for(VertexNode v :graph.vertexNodes)
        {
            edges.addAll(v.arcs);
            Set<Integer> treeVertex = new HashSet<>();
            treeVertex.add(v.index);
            treeVertexs.add(treeVertex);
        }
        Collections.sort(edges);
        for(EdgeNode e:edges)
        {
            if(isCircle(e,treeVertexs)){
                continue;
            }
            treeEdges.add(e);
            countWeight+=e.weight;
            if(treeEdges.size() == graph.vertexCount-1)
                break;
        }
System.out.println("最小生成树包括边：");
        for(EdgeNode e:treeEdges)
            System.out.println(e);
        System.out.println("总权重为"+countWeight);
    }

    public static void union(Set<Integer> set1,Set<Integer> set2)
    {
        set1.addAll(set2);
    }
    public static boolean isCircle(EdgeNode edge,Set<Set<Integer>> treeVertexs){
        for (Set<Integer> treeVertex : treeVertexs) {
            int size = treeVertex.size();
            if (!treeVertex.contains(edge.fromIndex))
                size++;
            if (!treeVertex.contains(edge.endIndex))
                size++;
            if (size == treeVertexs.size())
                return true;
            treeVertex.add(edge.fromIndex);
            treeVertex.add(edge.endIndex);
        }
        return false;
    }
}
