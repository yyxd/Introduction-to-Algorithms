import java.util.Random;

/**
 * Created by HinTi on 2018/4/25.
 */
public class Chap5_RandomPermutingAnArray {

    /**
     * 给定一个数组，随机化输出数组
     * 为每个元素nums[i]分配一个随机数p[i]作为其优先权，然后依据这些优先权对数组进行排序
     * @param nums 输入的数组
     */
    public void PermuteBySorrting(int[] nums)
    {
        int n = nums.length;
        int[] p = new int[n];
        Random random = new Random();
        for (int i = 1;i<n;i++)
            p[i]= random.nextInt(n*n*n);
        //将nums[i]按照p[i]的大小排序
    }

    public void PermuteInPlace(int[] nums)
    {

    }

}
