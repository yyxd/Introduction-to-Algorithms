package chap6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2018/4/27.
 * 使用最小堆实现优先队列
 * 最小堆：父节点小于子节点
 */
public class PriorityQueue {

    public static void test()
    {
        int []nums = {1,15,8,2,6,13,9,10,11,3,22};
        PriorityQueue priorityQueue = new PriorityQueue();
        for(int i :nums)
        {
            priorityQueue.Insert(i);
        }
        // System.out.println(priorityQueue);
        priorityQueue.Insert(5);
        // System.out.println(priorityQueue);
        priorityQueue.DecreseKey(6,4);
        System.out.println(priorityQueue);

        System.out.println("Extractmin: " + priorityQueue.ExtractMin());
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.Minium());
        System.out.println(priorityQueue);
    }
    List<Integer> heap = new ArrayList<>();
    int heapSize = 0;

    /**
     * 插入x值到堆中，首先在堆末尾添加一个元素，并定义为整数的最大值，然后将堆末尾的值减小到key
     * @param x
     */
    public void Insert(int x)
    {
        heapSize++;
        heap.add(Integer.MAX_VALUE);
        DecreseKey(heapSize-1,x);
    }

    /**
     * 返回堆的最小值
     * @return
     */
    public int Minium()
    {
        return heap.get(0);
    }

    /**
     * 去掉并返回堆中最小关键字的元素
     * @return 堆的最小值
     */
    public int ExtractMin()
    {
        if (heapSize<1)
            System.err.println("heap underflow");
        int min = heap.get(0);
        heap.set(0,heap.get(heapSize-1));
        heap.remove(heapSize-1);
        heapSize--;
        MinHeapify(0);
        return min;
    }
    private int left(int i)
    {
        return 2*i+1;
    }
    private int right(int i)
    {
        return 2*i+2;
    }
    private int parent(int i)
    {
        return  (i-1)/2>0?(i-1)/2:0;
    }

    /**
     * 维护最小堆，
     * @param i，第i个元素不满足最小堆的性质，但i的左右节点均满足最小堆的性质
     */
    public void MinHeapify(int i)
    {
        int smallest = i;
        int l = left(i),r=right(i);
        if(l<heapSize&&heap.get(l)<heap.get(i))
            smallest = l;
        if (r<heapSize&&heap.get(r)<heap.get(smallest))
            smallest = r;
        if(smallest!=i)
        {
            exchange(i,smallest);
            MinHeapify(smallest);
        }
    }
    private void exchange(int index1,int index2)
    {
        if(index1<0||index1>=heapSize||index2<0||index2>=heapSize)
            System.err.println("exchange overflow or underflow");
        int temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);
    }


    /**
     * 将堆中index 的值减小到key
     * 将可以不停的和父节点进行比较，如果key的值小于父节点则一直交换，直至key大于父节点找到合适位置或变为根节点
     * @param index
     * @param key
     */
    public void DecreseKey(int index, int key)
    {
        if(key>heap.get(index))
            System.err.println("new key is larger than current key");
        heap.set(index,key);
        while (index>0&&heap.get(parent(index))>heap.get(index))
        {
            exchange(index,parent(index));
            index=parent(index);
        }
    }

    @Override
    public String toString() {
        String string = new String();
       for(Integer integer :heap)
       {
           string=string+(integer+"  ");
       }
       return string;
    }
}
