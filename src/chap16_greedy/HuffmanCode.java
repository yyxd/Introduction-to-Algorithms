package chap16_greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2018/5/7.
 */
public class HuffmanCode {

    public static void main(String[] args) {
        HuffmanCode huffmanCode = new HuffmanCode();
        int[] freq = {45,13,12,16,9,5};
        char[] chars ={'a','b','c','d','e','f'};
        System.out.print("给定数据文件：\n字符序列: ");
        for(char s : chars)
            System.out.print(s+"\t");
        System.out.print("\n字符频率: ");
        for(int i : freq)
            System.out.print(i+"\t");
        System.out.println("\n根据数据文件构建哈夫曼树:");
        Node root  = huffmanCode.createTree(freq,chars);
        huffmanCode.printHuffmanTree(root);
    }

    public  Node createTree(int []freq, char[]s)
    {
        Node[] nodes = new Node[freq.length];
        for(int i=0;i<freq.length;i++){
            nodes[i] = new Node(s[i],freq[i]);
        }
        PriorityQueue queue = new PriorityQueue();
        for (int i = 0;i<nodes.length;i++)
        {
            queue.Insert(nodes[i]);
        }
        for(int i=0;i<nodes.length-1;i++)
        {
            Node x = queue.ExtractMin();
            Node y = queue.ExtractMin();
            Node z = new Node('\0',x.freq+y.freq);
            z.left = x;
            z.right = y;
            queue.Insert(z);
        }
        return queue.ExtractMin();
    }

    public void printHuffmanTree(Node node)
    {
        if(node!=null)
        {
            if(node.s!='\0')
                System.out.println("字符"+node.s+"的前缀码为："+node.prefixCode);
            if(node.left!=null)
            {
                node.left.prefixCode = node.prefixCode+"0";
                printHuffmanTree(node.left);
            }
            if(node.right!=null)
            {
                node.right.prefixCode = node.prefixCode+"1";
                printHuffmanTree(node.right);
            }
        }
    }

}

class Node{
    char s;
    int freq;
    String prefixCode="";
    Node left = null;
    Node right = null;
    public Node(char s, int freq) {
        this.s = s;
        this.freq = freq;
    }
}

class PriorityQueue{
    // '\0'代表特殊字符
    List<Node> heap = new ArrayList<>();
    int heapSize = 0;

    /**
     * 插入x值到堆中，首先在堆末尾添加一个元素，并定义为整数的最大值，然后将堆末尾的值减小到key
     * @param x
     */
    public void Insert(Node x)
    {
        heapSize++;
        heap.add(x);
        DecreseKey(heapSize-1,x);
    }

    /**
     * 返回堆的最小值
     * @return
     */
    public Node Minium()
    {
        return heap.get(0);
    }

    /**
     * 去掉并返回堆中最小关键字的元素
     * @return 堆的最小值
     */
    public Node ExtractMin()
    {
        if (heapSize<1)
            System.err.println("heap underflow");
        Node min = heap.get(0);
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
        if(l<heapSize&&heap.get(l).freq<heap.get(i).freq)
            smallest = l;
        if (r<heapSize&&heap.get(r).freq<heap.get(smallest).freq)
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
        Node temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);
    }


    /**
     * 将堆中index 的值减小到key
     * 将可以不停的和父节点进行比较，如果key的值小于父节点则一直交换，直至key大于父节点找到合适位置或变为根节点
     * @param index
     * @param key
     */
    public void DecreseKey(int index, Node key)
    {
        if(key.freq>heap.get(index).freq)
            System.err.println("new key is larger than current key");
        heap.set(index,key);
        while (index>0&&heap.get(parent(index)).freq>heap.get(index).freq)
        {
            exchange(index,parent(index));
            index=parent(index);
        }
    }

    @Override
    public String toString() {
        String string = new String();
        for(Node node :heap)
        {
            string=string+(node.s+"  ");
        }
        return string;
    }
}