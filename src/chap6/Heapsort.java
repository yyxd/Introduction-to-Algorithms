package chap6;

/**
 * Created by HinTi on 2018/4/25.
 * 堆排序，使用最大堆，可以对一个数组进行原址排序
 * heapSize 表明从数组元素0到heapSize里的值是符合最大堆的性质的
 *
 */
public class Heapsort {
    private int left(int i) {
        return  2*i+1;
    }
    private int right(int i){
        return 2*i+2;
    }

    /**
     * 维护一个最大堆，将A[i]与子节点比较，如果A[i]大于子节点，则已经满足最大堆的性质
     * 否则将A[i]与最大的子节点互换，再维护自己的子堆是最大堆
     * @param A
     * @param i 带插入堆中的值A[i],i的两个子节点均满足最大堆的性质
     * @param heapSize
     */
    public void MaxHeapify(int A[],int i,int heapSize)
    {
        int l = left(i),r=right(i);
        int largest=i;
        if(l<heapSize&&A[l]>A[i])
            largest = l;
        else
            largest=i;
        if(r<heapSize&&A[r]>A[largest])
            largest = r;
        if(largest!=i)
        {
            int temp = A[i];
            A[i] = A[largest];
            A[largest]=temp;
            MaxHeapify(A,largest,heapSize);
        }
    }

    /**
     * 建最大堆
     * @param A
     */
    public void BuildMaxHeap(int []A)
    {
        for (int i=A.length/2 ;i>=0;i--)
            MaxHeapify(A,i,A.length);
    }

    /**
     * 最大的元素始终为根节点，位于A[0]，将A[0]与堆最后一个数组互换，堆的长度-1，维护堆为最大堆
     * 直至堆的长度为1，此时数组已经是有序的了
     * @param A
     */
    public void HeapSort(int []A)
    {
        BuildMaxHeap(A);
        int heapSize = A.length;
        for (int i=A.length-1;i>=1;i--){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heapSize--;
            MaxHeapify(A,0,heapSize);
        }
    }

    public static void main(String[] args) {
        Heapsort heapsort =new Heapsort();
        int [] A={4,1,3,2,16,9,10,14,8,7};
        heapsort.HeapSort(A);
        for(int i:A){
            System.out.print(i+"\t");
        }
    }
}
