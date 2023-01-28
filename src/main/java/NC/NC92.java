package NC;

public class NC92 {

    public static void main(String[] args){
        String result = LCS("abcde","abc");
        System.out.println("result="+result);
    }

    /**
     * longest common subsequence
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS (String str1, String str2) {
        // write code here
        int max=0;
        int left2=0;
        int left=0,right=1;
        String shortone=str1.length()>=str2.length()?str2:str1;
        String longone=str1.length()<str2.length()?str2:str1;
        while(right!=shortone.length()+1){
            if(longone.contains(shortone.substring(left,right))){
                if(max<right-left){
                    max=right-left;
                    left2=left;
                }
                right+=1;
            }
            else{
                left+=1;
                right+=1;
            }
        }
        if(max==0)return "-1";
        return shortone.substring(left2,left2+max);

    }
}
