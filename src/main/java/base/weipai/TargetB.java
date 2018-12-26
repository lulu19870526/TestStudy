package base.weipai;

//员工B（真正做事的人）做自己擅长的工作
public class TargetB implements ITarget {
    @Override
    public void doSomething(String command) {
        System.out.println("我是员工B，现在开始干" + command + "");
    }
}
