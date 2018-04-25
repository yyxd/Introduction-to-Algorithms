import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2018/4/8.
 * 问题：归并排序，采用的是分治的思想
 */
public class Chap2_MergeSort {
    public void MergeSort(int[] nums,int lend,int rend)
    {
        if(lend<rend)
        {
            int q = (lend+rend)/2;
            MergeSort(nums,lend,q);
            MergeSort(nums,q+1,rend);
            Merge(nums,lend,q,rend);
        }
    }
//分成两段，p-q, q+1-r;
    public int[] Merge(int[] nums,int p,int q,int r)
    {
        int m=q-p+1,n=r-q;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
       for(int i = 0;i<m;i++)
           left.add(nums[i+p]);
       for (int i=0;i<n;i++)
           right.add(nums[i+q+1]);
       left.add(Integer.MAX_VALUE);
       right.add(Integer.MAX_VALUE);
       int i =0,j=0;
       for(int k = p;k<=r;k++)
       {
           if(left.get(i)<right.get(j))
           {
               nums[k] = left.get(i++);
           }else {
               nums[k] = right.get(j++);
           }
       }
       return nums;
    }
}
