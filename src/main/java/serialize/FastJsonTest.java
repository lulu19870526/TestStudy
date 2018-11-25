package serialize;

import com.alibaba.fastjson.JSON;

public class FastJsonTest {

    public static void main(String args[]){
        Student student = new Student("lulu",'女',18);
        //序列化
        String jsonStr = JSON.toJSONString(student);
        System.out.println("jsonStr="+jsonStr);
        //反序列化
        Student jsonObj = JSON.parseObject(jsonStr,Student.class);
        String name = jsonObj.getName();
        char sex = jsonObj.getSex();
        int age = jsonObj.getAge();
        System.out.println("name="+name+";sex="+sex+";age="+age);
    }
}
