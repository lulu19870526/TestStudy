package dynamicProgramming;


/**
 * 国王与金矿
 *    有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
 *    参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
 *    要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 *   1、400金/5人   2、500金/5人   3、200金/3人    4、300金/4人    5、350金/3人
 */
public class GuowangYuJinKuang2 {

    public static void main(String[] args){
        int[] p = new int[]{5,5,3,4,3};
        int[] g = new int[]{400,500,200,300,350};
        getMaxGold(5,10,g,p);
    }

    /**
     *
     * @param n   金矿数
     * @param w    总人数
     * @param gold  每个金矿含有的黄金数
     * @param people  每个金矿需要的工人数
     */
    public static void getMaxGold(int n,int w,int[] gold,int[] people){
        int[]  preResult = new int[w];
        int[]  result = new int[w];

        for(int i=0;i< w;i++){
            if(i+1 < people[0])
                preResult[i] = 0;
            else
                preResult[i] = gold[0];
        }
        print(preResult);

        for(int i =1;i<n;i++){
            for(int j = 0;j<w;j++){
                if(j+1 < people[i])
                    result[j] = preResult[j];
                else if(j+1 == people[i])
                    result[j] = Math.max(preResult[j],preResult[j-people[i]+1]+gold[i]);
                else
                    result[j] = Math.max(preResult[j],preResult[j-people[i]]+gold[i]);
            }
            preResult = result.clone();
            print(preResult);
        }

    }

    public static void print(int[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(" " + a[i]);
        System.out.println("");
    }
}
