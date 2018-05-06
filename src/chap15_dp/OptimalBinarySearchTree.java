package chap15_dp;

/**
 * Created by HinTi on 2018/5/6.
 */
public class OptimalBinarySearchTree {
    public static void main(String[] args) {
        String[] word = {"k1","k2","k3","k4","k5"};
        double[] p ={0.15,0.1,0.05,0.1,0.2};
        double[] q ={0.05,0.1,0.05,0.05,0.05,0.1};
        CreateTree(p,q,word);
    }
    /**
     *
     * @param p 每个关键字对应的概率 n个
     * @param q 带搜索的字不在word中，伪关键字的概率，n+1个，q[i]对应查询的字 < k[i]但 > k[i-1]
     * @param word 关键字
     * @return
     */
    public static double CreateTree(double p[],double q[],String word[])
    {
        int n = p.length;
        double []newp = new double[n+1];
        for(int i = 1;i<=n;i++)
            newp[i] = p[i-1];
        double[][] e = new double[n+2][n+1];
        double[][] w = new double[n+2][n+1];
        int[][]root = new int[n+2][n+1];
        for(int i = 1;i<=n+1;i++){
            e[i][i-1] = q[i-1];
            w[i][i-1] = q[i-1];
        }

        for(int l = 1;l<=n;l++)
        {
            for(int i =1;i<=n-l+1;i++)
            {
                int j = i+l-1;
                e[i][j] = Integer.MAX_VALUE;
                w[i][j] = w[i][j-1]+newp[j]+q[j];
                for(int r = i;r<=j;r++)
                {
                    double temp = e[i][r-1]+e[r+1][j]+w[i][j];
                    if (temp<e[i][j])
                    {
                        e[i][j] = temp;
                        root[i][j] =r;
                    }
                }
            }
        }
        printTree(root,word,1,n,"root");
        return e[1][n];
    }

    public static void printTree(int[][]root,String []word,int i,int j,String s)
    {
        if(i<1||i>word.length||j<1||j>word.length)
            return;
        if(root[i][j] == 0)
            return;
        if(s=="root")
            System.out.println("根节点为"+word[root[i][j]-1]);
        else if(s=="left")
            System.out.println(word[j]+"的左孩子为"+word[root[i][j]-1]);
        else
            System.out.println(word[i-2]+"的右孩子为"+word[root[i][j]-1]);
        printTree(root,word,i,root[i][j]-1,"left");
        printTree(root,word,root[i][j]+1,j,"right");

    }
}
