package base.factory;

//静态工厂方法模式,提供多个静态工厂方法，分别创建对象

/**
 * 工厂方法模式有一个问题就是，
 * 类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则
 */
public class SendFactory2 {

    public static Sender produceMail(){
        return new MailSender();
    }

    public  static Sender produceSms(){
        return new SmsSender();
    }
}
