package dynamicproxy;

/**
 * Created by zengqx on 2018/1/3.
 */
public class TestProxy {

    public static void main(String args[]){
        SingerService singerService = new SingerServiceImpl();
        SingerProxy proxy = new SingerProxy(singerService);

        proxy.sing("日不落");
        System.out.println("");
        proxy.dance("霓裳羽衣舞");

        ProxyGeneratorUtils.writeProxyClassToHardDisk("d:/$Proxy11.class");
    }
}
