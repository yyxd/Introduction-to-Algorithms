package chap16_greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2018/5/6.
 */
public class activitySelection {
    public static void main(String[] args) {
        int []s = {1,3,0,5,3,5,6,8,8,2,12};
        int []f = {4,5,6,7,9,9,10,11,12,14,16};
        selectActivities(s,f);
    }
    public static int selectActivities(int s[],int f[])
    {
        List<Integer> act = new ArrayList<>();
        act.add(1);
        for(int i =2;i<=f.length;i++)
        {
            if(s[i-1]<f[act.get(act.size()-1)-1])
                continue;
            act.add(i);
        }
        System.out.println("选择活动集：");
        for (int i :act)
            System.out.print(i+"\t");
        System.out.println();
        return act.size();
    }
}
