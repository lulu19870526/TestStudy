package algorithm.inttochinese;

/**
 * 数字转中文数字
 */
public class Test {

    public static void main(String[] args){

       String str1 = int2chineseNum(40010);
       System.out.println("str1="+str1);

       String str2 = int2chineseNum(401110);
       System.out.println("str2="+str2);

        String str3 = int2chineseNum(1000001110);
        System.out.println("str3="+str3);

    }

    public static String int2chineseNum(int src) {
        final String num[] = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        final String unit[] = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        String dst = "";
        int count = 0;
        while(src > 0) {
            dst = (num[src % 10] + unit[count]) + dst;
            src = src / 10;
            count++;
        }
        //+	匹配前面的子表达式一次或多次。要匹配 + 字符，请使用 \+。
        /*
        String s1 = dst.replaceAll("零[千百十]", "零");
        String s2  = s1.replaceAll("零+万", "万");
        String s3 = s2.replaceAll("零+亿", "亿");
        String s4 = s3.replaceAll("亿万", "亿零");
        String s5 = s4 .replaceAll("零+", "零");
        String s6 = s5 .replaceAll("零$", "");
        */

        return dst.replaceAll("零[千百十]", "零")
                .replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿")
                .replaceAll("亿万", "亿零")
                .replaceAll("零+", "零")
                .replaceAll("零$", "");

    }
}
