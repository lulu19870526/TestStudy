package base.factory;

public class SendFactory2Test {

    public static void main(String[] args){
        Sender sender = SendFactory2.produceMail();
        sender.Send();
    }
}
