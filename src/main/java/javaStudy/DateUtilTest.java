package javaStudy;

import java.text.ParseException;

/**
 * Created on 2018/11/03.
 */
public class DateUtilTest {
    public static class SimpleDateFormatThread extends Thread {

        private String dateStr;

        public SimpleDateFormatThread(String dateStr){
            this.dateStr = dateStr;
        }

        @Override
        public void run() {
                try {
                    //System.out.println(this.getName()+":"+DateUtil.parse(dateStr));
                    //System.out.println(this.getName()+":"+DateUtil1.parse(dateStr));
                    //System.out.println(this.getName()+":"+DateUtil2.parse(dateStr));
                    System.out.println(this.getName()+":"+DateUtil3.parse(dateStr));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        String dateStr = "2018-11-03 10:02:47";
        for(int i = 0; i < 5; i++){
            new SimpleDateFormatThread(dateStr).start();
        }

    }
}
