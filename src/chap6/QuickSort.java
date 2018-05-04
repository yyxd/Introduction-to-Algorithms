package chap6;

import java.util.Random;

/**
 * Created by HinTi on 2018/4/28.
 */
public class QuickSort {
    public static void test()
    {
        System.out.println("输入：");
        int []nums ={1,15,8,2,6,13,9,10,11,3,22};
        for(int i=0;i<nums.length;i++)
        {
            if(i==nums.length-1)
                System.out.println(nums[i]);
            else System.out.print(nums[i]+", ");
        }
        QuickSort quickSort = new QuickSort();
        quickSort.Quicksort(nums,0,nums.length-1);
        System.out.println("输出：");
        for(int i=0;i<nums.length;i++)
        {
            if(i==nums.length-1)System.out.println(nums[i]);
            else System.out.print(nums[i]+", ");
        }
        //随机化算法
    }


    public void RandomizedQuicksort(int[] A,int p,int r)
    {
        if(p<r){
            int q;
            if(p<r)
            {
                q= RandomizedPartition(A,p,r);
                RandomizedQuicksort(A,p,q-1);
                RandomizedQuicksort(A,q+1,r);
            }
        }
    }

    /**
     * 从p到r中随机化找到一个元素，作为主元
     * @param A
     * @param p
     * @param r
     * @return
     */
    public int RandomizedPartition(int[]A,int p,int r)
    {
        Random random = new Random();
        int i = random.nextInt(r-p)+p;
        int temp = A[i];
        A[i] = A[r];
        A[r] = temp;
        return Partition(A,p,r);
    }

    public void Quicksort(int []A,int p, int r)
    {
        int q;
        if(p<r)
        {
            q= Partition(A,p,r);
            Quicksort(A,p,q-1);
            Quicksort(A,q+1,r);
        }
    }
    public int Partition(int []A,int p,int r)
    {
        int x = A[r];
        int i = p-1;
        for(int j = p;j<r;j++)
        {
            if(A[j]<=x)
            {
                i++;
                int temp = A[i];
                A[i]=A[j];
                A[j]=temp;
            }
        }
        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i+1;
    }
}
