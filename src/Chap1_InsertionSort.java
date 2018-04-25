/**
 * Created by HinTi on 2018/4/8.
 * 插入排序
 * 问题：将一串数字按照升序排列
 * 输入：长度为n的int数组
 * 输出：升序排列的数组
 * 解决：采用插入排序的方式，将数组分为两段，排好序的和未排序的，从未排序的中选一个数，
 * 插入到排好序的数组中，形成新的排好序的数组
 * 注意：插入排序时移动数组要注意从后往前移动
 */
public class Chap1_InsertionSort {
    public int[] ISort(int [] nums)
    {
        for (int i=1;i<nums.length;i++)
        {
            int temp = nums[i];
            for(int j=0;j<i;j++)
            {
                if(nums[j]>temp)
                {
                    for(int k=i;k>j;k--)
                        nums[k]=nums[k-1];
                    nums[j]=temp;
                    break;
                }

            }
        }
        return nums;
    }

    public int[] ISort2(int[] nums)
    {
        for (int j=1;j<nums.length;j++)
        {
            int key = nums[j];
            int i = j-1;
            while (i>=0&&nums[i]>key)
            {
                nums[i+1] = nums[i];
                i--;
            }
            nums[i+1] = key;
        }
        return nums;
    }
}
