package base.factory.chouxiang;

import base.factory.Sender;

public class Test {

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
    }
