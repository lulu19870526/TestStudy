package study;


/**
 * Java中传参都是值传递，如果是基本类型，就是对值的拷贝，
 * 如果是对象，就是对引用地址的拷贝
 */
public class FunctionChuanValue {

    public static void main(String[] args){
        //基本类型
        /**
         * 基本类型的传参，在方法内部是值拷贝，有一个新的局部变量得到这个值，对这个局部变量的修改不影响原来的参数
         */
        int age1 = 18;
        System.out.println("age1="+age1);
        function3(age1);
        System.out.println("age1="+age1);

        int age2 = 18;
        System.out.println("age2="+age2);
        function4(age2);
        System.out.println("age2="+age2);

        //引用类型
        /**
         * 对象类型的传参，传递的是堆上的地址，在方法内部是有一个新的局部变量得到引用地址的拷贝，
         * 对该局部变量的操作，影响的是同一块地址，因此原本的参数也会受影响，
         * 反之，若修改局部变量的引用地址，则不会对原本的参数产生任何可能的影响。
         */
        User user =  new User("璐璐");
        System.out.println("user.getUserName()="+user.getUserName());
        function1(user);
        System.out.println("user.getUserName()="+user.getUserName());

        User user2 =  new User("璐璐");
        System.out.println("user2.getUserName()="+user2.getUserName());
        function2(user);
        System.out.println("user2.getUserName()="+user2.getUserName());

    }

    private static void function3(int a) {
        a = 2;
    }

    private static void function4(int a) {
        int b = 5;
        a = b;
    }

    private static void function1(User user) {
        user.setUserName("lulu");
    }

    private static void function2(User user) {
        User user1 = new User("beijing");
        user = user1;
        user.setUserName("北京");
    }
}

class User{
    private String userName;

    public User(){

    }
    public User(String userName){
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

}
