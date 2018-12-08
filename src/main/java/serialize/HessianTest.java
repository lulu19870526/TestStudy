package serialize;


import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class HessianTest {

    public static void main(String[] args){
        try {
            Student1 student = new Student1("璐璐",'女',18);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            //Hessian的序列化输出
            HessianOutput ho = new HessianOutput(os);
            ho.writeObject(student);

            ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
            //Hessian的反序列化读取对象
            HessianInput hi = new HessianInput(is);
            Student1 stu = (Student1)hi.readObject();

            String name = stu.getName();
            char sex = stu.getSex();
            int age = stu.getAge();
            System.out.println("name="+name+";sex="+sex+";age="+age);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class Student1 implements Serializable
{
    private String name;
    private char sex;
    private int age;

    public Student1(String name,char sex,int age)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    public Student1(){

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

