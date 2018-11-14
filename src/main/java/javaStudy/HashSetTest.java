package javaStudy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zengqx on 2018/11/2.
 */
public class HashSetTest {

    public static void main(String[] args){
        Integer int1 = Integer.valueOf("100");
        Integer int2 = Integer.valueOf("100");
        System.out.println("int1和in2是否相等:"+ (int1 == int2));

        Integer int3 = Integer.valueOf("128");
        Integer int4 = Integer.valueOf("128");
        System.out.println("int3和in4是否相等:"+ (int3 == int4));
        System.out.println("int3和in4是否equal:"+ (int3.equals(int4)));//比较基本类型int值是否相等

        Set<Object> set = new HashSet<Object>();
        boolean boolean1 = set.add(int1);
        boolean boolean2 = set.add(int2);
        System.out.println("boolean1="+boolean1+";boolean2="+boolean2);
        boolean boolean3 = set.add(int3);
        boolean boolean4 = set.add(int4);
        System.out.println("boolean3="+boolean3+";boolean4="+boolean4);

        Person person1 = new Person("lulu",'F',18);
        Person person2 = new Person("lulu",'F',18);
        System.out.println("person1="+person1+";person2="+person2);
        System.out.println("person1和person2是否相等:" + (person1 == person2) + ";是否相等equal:" + (person1.equals(person2)));
        boolean boolean5 = set.add(person1);
        boolean boolean6 = set.add(person2);
        System.out.println("boolean5="+boolean5+";boolean6="+boolean6);

        System.out.println("set size为"+set.size());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}

class Person
{
    private String name;
    private char sex;
    private int age;

    public Person(String name,char sex,int age)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


}
