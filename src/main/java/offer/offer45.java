package offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class offer45 {

    public static void main(String[] args){
        int remain = remainLast(5,3);
        System.out.println("remain="+remain);
        int remain1 = remainLast1(5,3);
        System.out.println("remain1="+remain1);
    }

    public static int remainLast1(int n,int m){
        int start = 0;
        for(int i=2;i<= n;i++){
            start = (start +m)%i;
        }
        return start;
    }



    public static int remainLast(int n,int m){
        if(n <= 0 || m <=0 )
            return -1;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
            list.add(i);

        int currentSize = list.size();
        Iterator<Integer> iterator = list.iterator();
        while(currentSize >1){
            for(int i=0;i<m;i++)
                if(iterator.hasNext())
                {
                    int temp = iterator.next();
                    //System.out.println("temp="+temp);
                }else{
                    iterator = list.iterator();
                    int temp = iterator.next();
                   // System.out.println("qqq temp="+temp);
                }

               iterator.remove();
                currentSize --;
        }
        iterator = list.iterator();
        return iterator.next();

    }
}
