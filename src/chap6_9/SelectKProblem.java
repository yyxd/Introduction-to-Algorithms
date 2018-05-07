package chap6_9;

import java.util.Random;

/**
 * Created by HinTi on 2018/5/3.
 * 在接近线性时间复杂度里，找出数组中第K大的元素
 */
public class SelectKProblem {
    private int k;//待找的数组第k大的元素
    public static void main(String[] args) {
        int []nums = {1,15,8,2,6,13,9,10,11,3,22};
        SelectKProblem skp = new SelectKProblem();
        System.out.println(skp.findi(nums,6));
    }


    /**
     *
     * @param nums
     * @param i
     * @return
     */
    public int findi(int []nums,int i)
    {
        this.k = nums.length-i; //数组中第i大的数字等同于第k小的数
        if(this.k<0)
            System.err.println("kth in array underflow");
        return randomizedSelect(nums,0,nums.length-1);
    }

    /**
     * 返回 数组nums p到r 第i小的元素
     * @param nums
     * @param p
     * @param r
     * @param i
     * @return
     */
    public int randomizedSelect(int []nums,int p,int r)
    {
        int q;
        if(p==r)
            return nums[p];
        q=randomizedPartition(nums,p,r);
        if(q==this.k)
            return nums[q];
        else if(q<this.k)
            //如果找到的主元下标小于k，在q+1~r中寻找
            return randomizedSelect(nums,q+1,r);
        else
            return randomizedSelect(nums,p,q-1);

    }

    private void exchange(int []nums,int index1,int index2)
    {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 随机选取主元，并返回主元所对应的下标i，即主元在数组元素中第i小
     * @param nums
     * @param p
     * @param r
     * @return
     */
    public int randomizedPartition(int[]nums,int p,int r)
    {
        Random random = new Random();
        int i = random.nextInt(r-p)+p;
        exchange(nums,r,i);
        return partition(nums,p,r);
    }
    public int partition(int []nums,int p,int r)
    {
        int q;
        int x=nums[r];
        int i = p-1;
        for (int j = p;j<=r;j++)
        {
            if(nums[j]<x)
            {
                i++;
                exchange(nums,i,j);
            }
        }
        q=i+1;
        exchange(nums,q,r);
        return q;
    }
}
