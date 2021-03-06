package javaStudy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by zengqx on 2018/11/1.
 */
public class SerializableTest {

    public static void main(String args[]){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(
                    "E:\\testserialize.txt"));
            Student student = new Student("lulu",'女',18);
            oos.writeObject(student);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\testserialize.txt"));
            Student studentInfo = (Student)ois.readObject();

            String name = studentInfo.getName();
            char sex = studentInfo.getSex();
            int age = studentInfo.getAge();
            System.out.println("name="+name+";sex="+sex+";age="+age);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}

class Student implements Serializable
{
    private String name;
    private char sex;
    private int age;

    public Student(String name,char sex,int age)
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
