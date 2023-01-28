package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2022/12/11 23:51
 */
public class NC269 {
    public static String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return str;
        }
        char[] arr = str.toCharArray();
        reverse(arr,0,arr.length - 1);
        int left = 0;
        int right = 0;
        while(right <= arr.length){
            if(right == arr.length || arr[right] ==' '){
                reverse(arr,left,right - 1);
                left = right + 1;
            }
            right++;
        }
        return new String(arr);
    }

    private static void reverse(char[] arr,int i,int j){
        while(i < j){
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static void main(String[] args){
        String result = ReverseSentence("nowcoder. a am I");
        System.out.println(result);
    }
}
