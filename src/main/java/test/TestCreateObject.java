package test;

import java.lang.reflect.Constructor;

//创建对象的5种方式
public class TestCreateObject {

    public static void main(String[] args){
        try {
            //使用new关键字
            Employee employee1 = new Employee();

            Class clz =  Class.forName("test.Employee");
             // 使用Class类的newInstance方法
            Employee employee2 = (Employee)clz.newInstance();
            System.out.println("employee2="+employee2.toString());

            //使用Constructor类的newInstance方法
            Constructor<Employee> constructor = clz.getDeclaredConstructor(String.class,String.class,int.class);
            Employee employee3 = constructor.newInstance("lulu","IT",18);
            System.out.println("employee3="+employee3.toString());

            //使用clone方法

            //使用反序列化





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
