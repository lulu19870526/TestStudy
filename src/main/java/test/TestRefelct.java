package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * Created by zengqx on 2017/12/12.
 */
public class TestRefelct {
    public static void main(String args[]) {
        try {
            //获取Class对象
            Class cls1 = Class.forName("test.Employee");//返回与给定的字符串名称相关联类或接口的Class对象
            /*
            Class cls2 = Employee.class;//每个类都有class属性

            Employee employee = new Employee("lulu","IT",30);
            Class cls3 = employee.getClass();//每个类的对象都有getClass()方法
            System.out.println("类名称----------");
            System.out.println("类名称cls1=" + cls1.getName());
            System.out.println("类名称cls2=" + cls2.getName());
            System.out.println("类名称cls3=" + cls3.getName());
            System.out.println("对象值----------");
            System.out.println("employee对象的值为:"+employee.toString());


            //获取类的对象
            Employee employeeNew1 = (test.Employee)cls1.newInstance();
            System.out.println("employeeNew1对象的值为:"+employeeNew1.toString());


            //取得类的全部属性,包括public、private和proteced，但是不包括父类的申明字段
            System.out.println("declaredFields----------");
            Field[] declaredFields = cls1.getDeclaredFields();
            for (Field field2 : declaredFields) {
                System.out.println("Employee类的属性declaredFields为"+field2 );
            }
            //获得类的所有的公共（public）的字段，包括父类
            System.out.println("fields----------");
            Field[] fields = cls1.getFields() ;
            for(Field field1 :fields){
                System.out.println("Employee类的属性fields为"+field1 );
            }


            //获得类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法
            Method[] declaredMethods = cls1.getDeclaredMethods();
            System.out.println("declaredMethods----------");
            for(Method method1 : declaredMethods){
                System.out.println("Employee类的declaredMethods为"+method1 +";修饰符为:"+ Modifier.toString(method1.getModifiers()));
            }
            //类的所有公用（public）方法，包括其继承类的公用方法
            Method[] methods = cls1.getMethods();
            System.out.println("methods----------");
            for(Method method2:methods){
                System.out.println("Employee类的methods为"+method2 );
            }

            //获取类的特定方法
            Method setAgeMethod = cls1.getMethod("setAge",int.class);
            System.out.println("setAgeMethod----------");
            System.out.println("Employee类的setAgeMethod为" + setAgeMethod);
            setAgeMethod.invoke(employeeNew1, 28);
            System.out.println("对象值----------");
            System.out.println("employeeNew1对象的值为:" + employeeNew1.toString());
            Class[] claArray = setAgeMethod.getParameterTypes();
            for(int i=0;i<claArray.length;i++ ){
                System.out.println("param:"+claArray[i]);
            }
            Type[] types = setAgeMethod.getGenericParameterTypes();
            for(int i=0;i<types.length;i++){
                System.out.println("paramtype:"+types[i]);
            }

            //获得age属性
            Field ageField = cls1.getDeclaredField( "age" ) ;
            //打破封装  实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
            //由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的
            ageField.setAccessible(true);
            //给属性赋值
            ageField.set(employeeNew1, 58);
            System.out.println("employeeNew1对象的值为:" + employeeNew1.toString());
*/
            Class<?>[] classArray =cls1.getInterfaces();
            for(Class cls : classArray){
                System.out.println("cls="+cls+";修饰符为"+Modifier.toString(cls.getDeclaredMethod("run",null).getModifiers()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Employee implements RunBase{
    public String name;//职员姓名
    private String department;//职员部门
    private int age; //年龄

    public Employee() {

    }

    public Employee(String name, String department, int age) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "name="+name+";department="+department+";age="+age;
    }

    public void run(){
        System.out.println("run()方法被调用");
    }
}

interface RunBase{
    void run();
}
