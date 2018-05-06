package chap15_dp;

/**
 * Created by HinTi on 2018/5/5.
 */
public class LCSProblem {
    public static void main(String[] args) {
        String s1="ABCBDA";
        String s2 = "BDCABA";
        System.out.println(LCSLength(s1,s2));
    }
    public static int LCSLength(String s1,String s2)
    {
        int [][]res = new int[s1.length()+1][s2.length()+1];
        int [][]path = new int[s1.length()+1][s2.length()+1];
        int i = 0,j = 0;
       res[i][j] = 0;
       for (i=0;i<s1.length()+1;i++)
           res[i][0] = 0;
        for (j=0;j<s2.length()+1;j++)
            res[0][j] = 0;
        for (i=1;i<=s1.length();i++)
            for (j=1;j<=s2.length();j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    res[i][j] = res[i-1][j-1]+1;
                    path[i][j] = 1;//左上
                }
                else if(res[i][j-1]>res[i-1][j]) {
                    res[i][j] = res[i][j - 1];
                    path[i][j] = 2;//左
                }
                else {
                    res[i][j] = res[i - 1][j];
                    path[i][j] = 3;//上
                }
            }
            i=s1.length();
        j=s2.length();
          printLCS(path,i,j,s1);
            System.out.println();
            return res[s1.length()][s2.length()];

    }

    public static void printLCS(int[][]path,int i,int j,String s)
    {
        if(i==0||j==0)
            return;
        if(path[i][j] ==1) {
            printLCS(path,i-1,j-1,s);
            System.out.print(s.charAt(i - 1)+"\t");
        }else if(path[i][j] ==2)
            printLCS(path,i,j-1,s);
        else printLCS(path,i-1,j,s);
    }
}
