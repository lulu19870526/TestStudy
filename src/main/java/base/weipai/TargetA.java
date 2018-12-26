package base.weipai;

//员工A（真正做事的人）做自己擅长的工作
public class TargetA implements ITarget {
    @Override
    public void doSomething(String command) {
        System.out.println("我是员工A，现在开始干" + command + "");
    }
}
