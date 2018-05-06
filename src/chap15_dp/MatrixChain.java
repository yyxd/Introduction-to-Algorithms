package chap15_dp;

/**
 * Created by HinTi on 2018/5/5.
 */
public class MatrixChain {
    public static int matrixChain(int []chain) {
        int n = chain.length - 1;
        int[][] m = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        int l = 2;//l是子矩阵链长度
        for(l=2;l<=n;l++)
        {
            for(int i = 1;i<=n-l+1;i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i;k<j;k++)
                {
                    int temp = m[i][k] + m[k + 1][j] + chain[i - 1] * chain[k] * chain[j];
                    if (temp < m[i][j])
                        m[i][j] = temp;
                }
            }

        }

        for (int i = 1; i <= n; i++){
            for (int j = i + 1; j <= n; j++) {
                System.out.print("m["+i+"]["+j+"] = "+m[i][j]+"\t");
            }
            System.out.println();
    }
    return m[1][n];
    }

    public static void main(String[] args) {
        int[] chain = {30,35,15,5,10,20,25};
        matrixChain(chain);
    }
}
