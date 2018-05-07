package chap26_maxflow;
/**
 * 流量边
 */
public class FlowEdge {
	    private int v;  
	    private int w;  
	    private double capacity;  
	    private double flow;  
	   
	    public FlowEdge(int v, int w, double capacity) {  
	        this.v = v;  
	        this.w = w;  
	        this.capacity = capacity;  
	    }  
	   
	    public int from() {  
	        return v;  
	    }  
	   
	    public int to() {  
	        return w;  
	    }  
	   
	    public double capactity() {  
	        return capacity;  
	    }  
	   
	    public double flow() {  
	        return flow;  
	    }  
	   
	    public int other(int v) {  
	        if (v == this.v) return this.w;  
	        else return this.v;  
	    }  
	   
	    // 返回能够增加的最大流量  
	    public double residualCapacityTo(int v) {  
	        if (v == this.v) return flow;  
	        else return capacity - flow;  
	    }  
	   
	    // 增加这条边的流量  
	    public void addResidualFlowTo(int v, double d) {  
	        if (v == this.v) flow -= d;  
	        else flow += d;  
	    }  
	}  

