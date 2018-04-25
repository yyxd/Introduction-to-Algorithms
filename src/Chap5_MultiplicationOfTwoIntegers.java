import java.math.BigInteger;

/**
 * Created by HinTi on 2018/4/8.
 * 整数相乘
 */
public class Chap5_MultiplicationOfTwoIntegers {
    public long Multiply(int x, int y, int n)
    {
        if(n==1)
           return (long) x*y;
        else {
            int m = (n+1)/2;
            int temp = (int)Math.pow(10,m);
            int a = x/temp,b=x%temp,c=y/temp,d=y%temp;
            long e= Multiply(a,c,m);
            long f= Multiply(b,d,m);
            long g= Multiply(b,c,m);
            long h= Multiply(a,d,m);
            return (long)temp*temp*e+temp*(g+h)+f;
        }
    }

    public long FastMultiply(int x,int y,int n) {
        if (n == 1)
            return (long) x * y;
        else {
            int m = (n + 1) / 2;
            int temp = (int) Math.pow(10, m);
            int a = x / temp, b = x % temp, c = y / temp, d = y % temp;
            long e = FastMultiply(a, c, m);
            long f = FastMultiply(b, d, m);
            long g = FastMultiply(a - b, c - d, m);
            return (long) temp * temp * e + temp * (e + f - g) + f;
        }
    }
}
