package base.weipai;

/**
 * 委派设计模式
 * 公司老板给项目经理下达任务，将任务全权交给项目经理，
 * 由项目经理根据一定的策略将任务分配给小组成员，项目经理从头跟到尾。
 * 项目经理就像一个受老板授权的中介，老板不需要和小组成员直接联系，甚至可以不知道他的存在
 */

//员工实现同一个干活的接口
public interface ITarget {
    public void doSomething(String command);
}
