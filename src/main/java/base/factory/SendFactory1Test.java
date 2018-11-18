package base.factory;

public class SendFactory1Test {

    public static void main(String[] args){
        SendFactory1 factory1 = new SendFactory1();
        Sender sender = factory1.produce("sms");
        sender.Send();
    }
}
