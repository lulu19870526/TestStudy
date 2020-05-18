package base.command;

/**
 * 命令模式 (Command)
 * 将一个请求封装为一个对象，从而使你可以用不同的请求对客户进行参数化；
 * 对请求排队或请求日志，以及支持可撤销的操作。
 */
public class CommandPattern {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.ExecuteCommand();
    }
}
