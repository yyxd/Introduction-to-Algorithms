package util;

/**
 * Created by HinTi on 2018/5/6.
 */
public class SortBbyA {
    public static void sort(int []A,int []B)
    {
        Quicksort(A,B,0,A.length-1);
        //return B;
    }

    /**
     * 重载，根据数组A的值，对A，B进行排序
     * @param A
     * @param B
     */
    public static void sort(double []A,int []B)
    {
        Quicksort(A,B,0,A.length-1);
        //return B;
    }
    public static void Quicksort(int []A,int[]B,int p, int r)
    {
        int q;
        if(p<r)
        {
            q= Partition(A,B,p,r);
            Quicksort(A,B,p,q-1);
            Quicksort(A,B,q+1,r);
        }
    }

    public static void Quicksort(double []A,int[]B,int p, int r)
    {
        int q;
        if(p<r)
        {
            q= Partition(A,B,p,r);
            Quicksort(A,B,p,q-1);
            Quicksort(A,B,q+1,r);
        }
    }

    public static int Partition(double []A,int[]B,int p,int r)
    {
        double x = A[r];
        int i = p-1;
        for(int j = p;j<r;j++)
        {
            if(A[j]<=x)
            {
                i++;
                double temp = A[i];
                A[i]=A[j];
                A[j]=temp;
                int tempB = B[i];
                B[i] = B[j];
                B[j] = tempB;
            }
        }
        double temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;

        int tempB = B[i+1];
        B[i+1] = B[r];
        B[r] = tempB;
        return i+1;
    }

    public static int Partition(int []A,int[]B,int p,int r)
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
                int tempB = B[i];
                B[i] = B[j];
                B[j] = tempB;
            }
        }
        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;

        int tempB = B[i+1];
        B[i+1] = B[r];
        B[r] = tempB;
        return i+1;
    }
}
