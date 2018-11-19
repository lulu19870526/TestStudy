package basic;

public class EqualTest {
    //==是判断两个变量或实例是不是指向同一个内存空间。
    // equals是判断两个变量或实例所指向的内存空间的值是不是相同。
    public static void main(String[] args){
        String a = new String("ab");// a 为一个引用
        String b = new String("ab");//b为另一个引用,对象的内容一样
        String aa = "ab";// 放在常量池中
        String bb = "ab";//从常量池中查找

        System.out.println(aa == bb);//true
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true
        System.out.println(42 == 42.0);//true

        Object object1 = new Object();
        Object object2 = new Object();
        System.out.println(object1 == object2);//false
        System.out.println(object1.equals(object2));//false


    }

}
