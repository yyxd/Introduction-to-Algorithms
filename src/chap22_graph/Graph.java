package chap22_graph;

import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2018/5/7.
 * 邻接链表实现图算法
 */
public class Graph {
List<VertexNode> vertexNodes;//保存邻接表的节点
    int edgeCount;//边个数
    int vertexCount;//节点个数
    public void ResetVisit() {
        for(int i =0;i<visit.length;i++)
            visit[i] = false;
    }

    boolean[] visit;

    public Graph(int vertexCount)
    {
        this.vertexCount = vertexCount;
        this.edgeCount = 0;
        visit = new boolean[vertexCount];
        vertexNodes = new ArrayList<>();
        for(int i =0 ;i<vertexCount;i++)
        {
            VertexNode node = new VertexNode(i);
            vertexNodes.add(node);
        }
    }

    public void addWuxiangEdge(int fromIndex,int endIndex,int weight)
    {
        EdgeNode eNode1 = new EdgeNode(fromIndex,endIndex,weight);
        EdgeNode eNode2 = new EdgeNode(endIndex,fromIndex,weight);
        VertexNode vNode1 = this.vertexNodes.get(fromIndex);
        vNode1.arcs.add(eNode1);
        VertexNode vNode2 = this.vertexNodes.get(endIndex);
        vNode2.arcs.add(eNode2);
        edgeCount++;
    }
    public void addEdge(int fromIndex,int endIndex,int weight)
    {
        EdgeNode eNode = new EdgeNode(fromIndex,endIndex,weight);
        VertexNode vNode = this.vertexNodes.get(fromIndex);
        vNode.arcs.add(eNode);
        edgeCount++;
    }

    public void addEdge(EdgeNode e)
    {
        vertexNodes.get(e.fromIndex).arcs.add(e);
        edgeCount++;
    }

    public int findByName(String name) {
        for(int i =0;i<vertexNodes.size();i++)
            if(vertexNodes.get(i).name.equals(name))
                return i;
        return -1;
    }

    @Override
    public String toString() {
        String res = "";
        for (VertexNode n: vertexNodes)
        {
            res += ("节点"+n.index);
            for (EdgeNode e: n.arcs)
                res += ("->"+e.endIndex);
            res = res+"\n";
        }
        return res;
    }
}
class EdgeNode implements Comparable<EdgeNode>{
    int fromIndex;
    int endIndex; //边的终结点
    int weight;//权值

    public EdgeNode(int fromIndex,int endIndex, int weight) {
        this.fromIndex = fromIndex;
        this.endIndex = endIndex;
        this.weight = weight;
    }

    @Override
    public int compareTo(EdgeNode o) {
        int oWeight = o.weight;
        return weight>oWeight?1:(weight==oWeight?0:-1);
    }
    @Override
    public String toString()
    {
        String str = "边："+fromIndex+"->"+endIndex+" 权重"+weight;
        return str;
    }
}

class VertexNode{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name = "";
    int index;
//    EdgeNode firstArc = new EdgeNode();//指向第一条边
    List<EdgeNode> arcs = new ArrayList<>();//保存该顶点的所有边

    public VertexNode(int index) {
        this.index = index;
    }
}