package chap17_amortizedAnalysis;

/**
 * Created by HinTi on 2018/5/7.
 * 摊还代价为O(1)
 */
public class DynamicTable {
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTable(int index) {
        if(index<num)
            return table[index];
        else
            System.err.println("表溢出");
        return index;
    }

    public void setTable(int[] table) {
        this.table = table;
    }

    int size = 0;
    int num = 0;
    int []table;
    public void Insert(int x)
    {
        if(size == 0)
        {
            size=1;
            table = new int[size];
        }
        if (num == size)
        {
            int []newTable = new int[size*2];
            for(int i =0;i<size;i++)
                newTable[i] = table[i];
            table = newTable;
            size*=2;
        }
        table[num] = x;
        num++;
    }

    public static void main(String[] args) {
        DynamicTable table = new DynamicTable();
        int[] nums = {1,3,5,6,7,12,13,16,17,8,6};
        for(int i=0;i<nums.length;i++)
        {
            table.Insert(nums[i]);
            System.out.println("插入元素"+nums[i]+"\t表容量："+table.size+"\t表实际大小： "+table.num);
        }

    }
}
