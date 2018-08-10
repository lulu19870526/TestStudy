/**
 * Created by zengqx on 2017/12/11.
 */
public class TestString {
    public static void main(String args[]){
        char whiteChar = ' ';
        int acsii = whiteChar;
        System.out.println("空格的acsii值为"+acsii);

        String s = "abcdefg";
        String subStr1 = s.substring(2);
        String subStr2 = s.substring(2,5);

        System.out.println("subStr1="+subStr1);
        System.out.println("subStr2="+subStr2);
    }
}
