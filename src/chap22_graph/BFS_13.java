package chap22_graph;
/**
 * 广度优先搜索
 */
import java.util.LinkedList;

public class BFS_13 {
	private static void broadFirstSearch(AMWGraph G,boolean[] isVisited,int i) {
	        int u,w;
	        LinkedList queue=new LinkedList();
	        
	        //访问结点i
	        System.out.print(G.getValueByIndex(i)+"  ");
	        isVisited[i]=true;
	        //结点入队列
	        queue.addLast(i);
	        while (!queue.isEmpty()) {
	            u=((Integer)queue.removeFirst()).intValue();
	            w=G.getFirstNeighbor(u);
	            while(w!=-1) {
	                if(!isVisited[w]) {
	                        //访问该结点
	                        System.out.print(G.getValueByIndex(w)+"  ");
	                        //标记已被访问
	                        isVisited[w]=true;
	                        //入队列
	                        queue.addLast(w);
	                }
	                //寻找下一个邻接结点
	                w=G.getNextNeighbor(u, w);
	            }
	        }
	    }
	    
	    //对外公开函数，广度优先遍历
	  public  static void broadFirstSearch(AMWGraph G) {
	    	int n=G.getNumOfVertex();
	    	 boolean[] isVisited = new boolean[n];
	    	 for (int i = 0; i < n; i++) {
	                isVisited[i] = false;
	    		        }
	        for(int i=0;i<n;i++) {
	            if(!isVisited[i]) {
	                broadFirstSearch(G,isVisited, i);
	            }
	        }
	    }
	
public static void main(String args[]) {
    int n=8,e=9;//分别代表结点个数和边的数目
    String labels[]={"1","2","3","4","5","6","7","8"};//结点的标识
    AMWGraph graph=new AMWGraph(n);
    for(String label:labels) {
        graph.insertVertex(label);//插入结点
    }
    //插入九条边
    graph.insertEdge(0, 1, 1);
    graph.insertEdge(0, 2, 1);
    graph.insertEdge(1, 3, 1);
    graph.insertEdge(1, 4, 1);
    graph.insertEdge(3, 7, 1);
    graph.insertEdge(4, 7, 1);
    graph.insertEdge(2, 5, 1);
    graph.insertEdge(2, 6, 1);
    graph.insertEdge(5, 6, 1);
    graph.insertEdge(1, 0, 1);
    graph.insertEdge(2, 0, 1);
    graph.insertEdge(3, 1, 1);
    graph.insertEdge(4, 1, 1);
    graph.insertEdge(7, 3, 1);
    graph.insertEdge(7, 4, 1);
    graph.insertEdge(6, 2, 1);
    graph.insertEdge(5, 2, 1);
    graph.insertEdge(6, 5, 1);
    
  
    System.out.println("广度优先搜索序列为：");
    broadFirstSearch(graph);
}
}
	
	
	
	


