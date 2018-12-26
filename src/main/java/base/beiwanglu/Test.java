package base.beiwanglu;


/**
 * 备忘录模式是一种软件设计模式：在不破坏封闭的前提下，
 * 捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。
 * 一听到备忘录这个字的时候想起了小小时打的游戏，每次遇到大boss的时候都会保存一下进度，
 * 打过了就不需要恢复记录，打不过肯定就复原到刚刚保存的记录咯，重新打一遍BOSS，打死为止。
 * 哈哈，这就是备忘录模式
 */
public class Test {

    public static void main(String[] args){
        GameRole role = new GameRole();
        role.init();
        role.show();

        RoleStateMange manage = new RoleStateMange();
        manage.setMemento(role.saveMemento());

        role.fightBoss();
        role.show();

        role.recove(manage.getMemento());
        role.show();
    }
}
