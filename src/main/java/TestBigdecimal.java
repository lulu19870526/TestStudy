import java.math.BigDecimal;

/**
 * Created by zengqx on 2018/1/9.
 */
public class TestBigdecimal {

    public static void main(String args[]){
        BigDecimal bigDecimal = new BigDecimal(Double.toString(-1000));
        System.out.println("value="+bigDecimal.longValue());
    }
}
