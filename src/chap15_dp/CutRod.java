package chap15_dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HinTi on 2018/5/4.
 */
public class CutRod {
    public static void main(String[] args) {
        int []cut = {1,5,8,9,10,17,17,20,24,30};
        int rod=15;
        for(int i = 1;i<=rod;i++)
        {
            Map<Integer,int[]> ans = cutrod(i,cut);
            for(int j:ans.keySet()) {
                System.out.println("钢条长度为" + i + "，此时钢条切割最大收益为" + j);
                System.out.print("钢条切割方案为:\t");
                int []s = ans.get(j);
                int n = i;
                int cutLength = 0;
                while (n > 0 && s[n] != 0) {
                    cutLength += s[n];
                    System.out.print(s[n]+"\t");
                    n = n - s[n];
                }
                System.out.println(i-cutLength);
            }
        }
    }

    public static Map<Integer,int[]> cutrod(int rodLength, int []cut)
    {
        int []rods = new int[rodLength+1];
        int []s = new int[rodLength+1];
        rods[0] = 0;
        for(int i =1;i<rods.length;i++)
        {
            s[i] = 0;
            int max = 0;
            if(i-1<cut.length)
                max = cut[i-1];
            for (int j=1;j<i;j++)
            {
               int temp =  rods[j] + rods[i-j];
               if(temp>max){
                   max = temp;
                   s[i] = j;//保存切割方案,从左向右切割，保存的是钢条的第一段切割长度
               }
            }
            rods[i] = max;
        }
        Map<Integer,int[]> res = new HashMap<>();
        res.put(rods[rodLength],s);
        return res;
    }
}
