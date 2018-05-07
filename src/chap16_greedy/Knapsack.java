package chap16_greedy;

import util.SortBbyA;

/**
 * Created by HinTi on 2018/5/6.
 * 0-1背包问题，使用动态规划解决
 */
public class Knapsack {

    /**
     * 完全背包问题，每种物品有无限多
     * @param w w[i] 第i个物品重量
     * @param v v[i] 第i个物品价值
     * @param W 背包重量
     * @return 背包最大价值
     */
    public static int knapsack_complete(int w[], int v[], int W) {
        int backpack[] = new int[W + 1];
        backpack[0] = 0;
        for (int load = 1; load <= W; load++) {
            backpack[load] = 0;
            for (int j = 0; j < w.length; j++) {
                int temp;
                if (load - w[j] < 0) temp = 0;
                else temp = backpack[load - w[j]] + v[j];
                if (temp > backpack[load])
                    backpack[load] = temp;
            }
        }
        return backpack[W];
    }

    public static double Knapsack_fraction(int []w,int[]v,int W)
    {
        double ans = 0;
        double []f = new double[w.length];
        for(int i = 0;i<w.length;i++)
            f[i] = (double)v[i]/(double)w[i];
        SortBbyA.sort(f,w);
//        for(int i = 0;i<f.length;i++){
//            System.out.println(f[i]);
//        }
        int load = 0,i=f.length-1;
        while (i>=0&&load<W)
        {
            if(w[i]<=W-load) {
                load += w[i];
                ans += (w[i] * f[i]);
            }else {

                ans += (W-load)*f[i];
                load = W;
            }
        }
        return ans;
    }

    /**
     * 01背包 每种物品只有一个
     * @param w w[i] 第i个物品重量
     * @param v v[i] 第i个物品价值
     * @param W 背包重量
     * @return 背包最大价值
     */
    public static int Knapsack_01(int[] w, int[] v, int W) {
        if(w.length!=v.length||w.length<=0)
            System.err.println("输入数据不合法");
        int[][] backpack = new int[W + 1][w.length];
        for (int i = 0; i < w.length; i++)
            backpack[0][i] = 0;
        for (int load = 1; load <= W; load++)
            if (load >= v[0])
                backpack[load][0] = v[0];
            else
                backpack[load][0] = 0;
        for (int load = 1; load <= W; load++)
            for (int i = 1; i < w.length; i++) {
                if (load >= w[i])
                    backpack[load][i] = Math.max(backpack[load][i - 1], backpack[load - w[i]][i - 1] + v[i]);
                else
                    backpack[load][i] = backpack[load][i - 1];
            }
            return backpack[W][w.length-1];
    }

    public static void main(String[] args) {
        int[] w_f = {10, 20, 30,100};
        int[] v_f = {60, 100, 120,10000};
        int W = 50;
        System.out.print("分数背包问题\n输入数据：\n物品重量:");
        for(int i = 0;i<w_f.length;i++)
        {
            System.out.print(w_f[i]+"\t");
        }
        System.out.print("\n物品价值:");
        for(int i = 0;i<w_f.length;i++)
        {
            System.out.print(v_f[i]+"\t");
        }
        System.out.println("\n背包容纳量为"+W+",可背负最大价值："+Knapsack_fraction(w_f, v_f, W));
    }
}
