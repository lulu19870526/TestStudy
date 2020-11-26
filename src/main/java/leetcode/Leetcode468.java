package leetcode;

public class Leetcode468 {

    public static void main(String[] args){
        String result = validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
        System.out.println("result:"+result);
    }

    public static String validIPAddress(String IP) {

        if(isIPv4(IP))
            return "IPv4";
        else if(isIPv6(IP))
            return "IPv6";
        else
            return "Neither";
    }


    public static boolean isIPv6(String IP){
        if(IP == null || IP.length() == 0)
            return false;
        String[] arr = IP.split(":",10);
        if(arr != null){
            if(arr.length != 8)
                return false;
            for(int i = 0;i < arr.length;i++){
                String temp = arr[i];
                if(temp == null || temp.length() == 0 || temp.length() > 4)
                    return false;
                for(int j=0;j < temp.length();j++){
                    char tempChar = temp.charAt(j);
                    boolean flag = (tempChar >= '0' && tempChar <= '9') ||
                            (tempChar >= 'a' && tempChar <= 'f') ||
                            (tempChar >= 'A' && tempChar <= 'F');
                    if(!flag)
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isIPv4(String IP){
        if(IP == null || IP.length() == 0)
            return false;
        String[] arr = IP.split("\\.",5);
        if(arr != null){
            if(arr.length != 4)
                return false;
            for(int i = 0;i < arr.length;i++){
                String temp = arr[i];
                if(temp == null || temp.length() == 0)
                    return false;
                if(temp.charAt(0) == '0' && temp.length() > 1)
                    return false;
                int num = 0;
                for(int j = 0;j < temp.length();j++) {
                    char t = temp.charAt(j);
                    if (t < '0' || t > '9')
                        return false;
                    num = num * 10 + (temp.charAt(j) - '0');
                }
                if(num < 0 || num > 255)
                    return false;
            }
            return true;
        }
        return false;
    }
}
