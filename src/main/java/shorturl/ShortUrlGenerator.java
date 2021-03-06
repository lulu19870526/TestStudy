package shorturl;

/**
 * Generator ShortUrl
 * 数据库中需要保存长链与短链之间的关系，通过访问短链跳转到长链接
 *
 */
public class ShortUrlGenerator {
    public static void main(String[] args) {
        String sLongUrl = "http://www.baidu.com";
        for (String shortUrl : shortUrl(sLongUrl)) {
            System.out.println(shortUrl);
        }
    }


    /**
     * 1)将长网址md5生成32位签名串,分为4段, 每段8个字节;
     * 2)对这四段循环处理, 取8个字节, 将他看成16进制串与0x3fffffff(30位1)与操作, 即超过30位的忽略处理;
     * 3)这30位分成6段, 每5位的数字作为字母表的索引取得特定字符, 依次进行获得6位字符串;
     * 4)总的md5串可以获得4个6位串; 取里面的任意一个就可作为这个长url的短url地址;
     * 这种算法,虽然会生成4个,但是仍然存在重复几率,下面的算法一和三,就是这种的实现.
     * @param url
     * @return
     */
    public static String[] shortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "wangyang";
        // 要使用生成 URL 的字符
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"
        };
        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult = (Encript.md5(key + url));
        System.out.println("sMD5EncryptResult="+sMD5EncryptResult);
        String hex = sMD5EncryptResult;
        String[] resUrl = new String[4];
        //得到 4组短链接字符串
        for (int i = 0; i < 4; i++) {
            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);
            //8位16进制，每一位16进制数可以代替4位二进制数，所以8位16进制是32位，而0x3fffffff(30位1)
            //取8个字节, 将他看成16进制串与0x3fffffff(30位1)与操作, 即超过30位的忽略处理;
            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            String outChars = "";

            System.out.println("chars.length="+chars.length+";a="+0x0000003D);
            //循环获得每组6位的字符串
            for (int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引(具体需要看chars数组的长度   以防下标溢出，注意起点为0)
                //chars数组的长度26+10+26=62，索引从0到61,而 0x0000003D为61
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[(int) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }
}