package truetest;

/**
 * 求大字符串里面重复出现的最长子串的所有出现第一个位置
 * 用例1：输入：ABCDABC ，输出：0，4
 * 用例2：输入：ABC ，输出：null
 * 用例3：输入：AAAA，输出：0，1
 * 用例4：输入：ABCDEABDE，输出：0，5（相同长度串AB和DE，取第一个AB即可）
 */
public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        //System.out.println("Hello World!");

        String str1 = "ABCDABC";
        int[] result = getMaxLenth(str1);
        printFun(result);

        String str2 = "ABC";
        int[] result1 = getMaxLenth(str2);
        printFun(result1);

        String str3 = "AAAA";
        int[] result2 = getMaxLenth(str3);
        printFun(result2);

        String str4 = "ABCDEABDE";
        int[] result3 = getMaxLenth(str4);
        printFun(result3);

    }

    public static void printFun(int[] result){
        if(result != null && result.length > 1){
            System.out.println(result[0] + "," + result[1]);
        }
    }

    public static int[] getMaxLenth(String str){
        if(str == null || str.length() <= 0)
            return null;
        int max = Integer.MIN_VALUE;
        int[] result = new int[2];
        for(int i = 0;i < str.length();i++){
            for(int j = i+1;j < str.length();j++){
                int count = 0;
                if(str.charAt(i) == str.charAt(j)){
                    count++;
                    int m = i + 1;
                    int n = j + 1;
                    while(m < str.length() && n < str.length()){
                        if(str.charAt(m) == str.charAt(n)){
                            count++;
                            m++;
                            n++;
                        }else{
                            break;
                        }
                    }

                }
                if(max < count && count != 0){
                    System.out.println("hello");
                    max = count;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        if(max == Integer.MIN_VALUE)
            return null;
        else
            return result;
    }
}
