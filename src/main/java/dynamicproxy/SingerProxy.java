package dynamicproxy;

/**
 * Created by zengqx on 2018/1/3.
 */
public class SingerProxy implements SingerService {

    private SingerService singerService;

    public SingerProxy(SingerService singerService){
        this.singerService = singerService;
    }

    public void sing(String songName){
        System.out.println("将要执行方法名为sing的方法");
        singerService.sing(songName);
        System.out.println("已经执行完方法名为sing的方法");
    }

    public void dance(String danceName){
        System.out.println("将要执行方法名为dance的方法");
        singerService.dance(danceName);
        System.out.println("已经执行完方法名为dance的方法");
    }
}
