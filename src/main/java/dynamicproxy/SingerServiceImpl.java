package dynamicproxy;

/**
 * Created by zengqx on 2018/1/3.
 */
public class SingerServiceImpl implements SingerService {

    public void sing(String songName) {
        System.out.println("唱歌曲名为" + songName+"的歌曲");
    }

    public void dance(String danceName){
        System.out.println("跳舞蹈名为" + danceName+"的舞蹈");
    }
}
