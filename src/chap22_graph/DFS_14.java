package chap22_graph;
/**
 * 深度优先搜索
 */

public class DFS_14 {
	private static void depthFirstSearch(AMWGraph G,boolean[] isVisited,int  i) {
        //首先访问该结点，在控制台打印出来
        System.out.print(G.getValueByIndex(i)+"  ");
        //置该结点为已访问
        isVisited[i]=true;
        
        int w=G.getFirstNeighbor(i);//
        while (w!=-1) {
            if (!isVisited[w]) {
                depthFirstSearch(G,isVisited,w);
            }
            w=G.getNextNeighbor(i, w);
        }
    }
    
    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public static void depthFirstSearch(AMWGraph G) {
    	int n=G.getNumOfVertex();
   	 boolean[] isVisited = new boolean[n];
   	 for (int i = 0; i < n; i++) {
               isVisited[i] = false;
   		        }
        for(int i=0;i<n;i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!isVisited[i]) {
                depthFirstSearch(G,isVisited,i);
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
        
      
        System.out.println("深度优先搜索序列为：");
        depthFirstSearch(graph);
    }

}
