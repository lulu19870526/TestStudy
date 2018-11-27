package base.template;

/**
 *  模板设计模式
 *  定义一个操作中算法的骨架，而将一些步骤延迟到子类中，
 *  模板方法使得子类可以不改变算法的结构即可重定义该算法的某些特定步骤。
 *
 * 　 通俗点的理解就是 ：完成一件事情，有固定的数个步骤，但是每个步骤根据对象的不同，
 * 而实现细节不同；就可以在父类中定义一个完成该事情的总方法，
 * 按照完成事件需要的步骤去调用其每个步骤的实现方法。每个步骤的具体实现，由子类完成。
 */

/**
 *  比如我们做菜可以分为三个步骤 （1）备料 （2）具体做菜 （3）盛菜端给客人享用，
 *  这三部就是算法的骨架 ；然而做不同菜需要的料，做的方法，
 *  以及如何盛装给客人享用都是不同的这个就是不同的实现细节。
 */
public abstract class DodishTemplate {
    /**
     * 具体的整个过程
     */
    protected void dodish(){
        this.preparation();
        this.doing();
        this.carriedDishes();
    }
    /**
     * 备料
     */
    public abstract void preparation();
    /**
     * 做菜
     */
    public abstract void doing();
    /**
     * 上菜
     */
    public abstract void carriedDishes ();
}
