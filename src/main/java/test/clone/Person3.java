package test.clone;

import java.io.*;

/**
 * 利用序列化实现深拷贝
 * 被复制对象的继承链、引用链上的每一个对象都实现java.io.Serializable接口
 */
public class Person3 implements Serializable {

    private Address3 address3;
    private String name;

    public Person3(Address3 address3,String name){
        this.address3 = address3;
        this.name = name;
    }

    public void setAddress3(Address3 address3){
        this.address3 = address3;
    }

    public void setName(String name){
        this.name = name;
    }

    public Address3 getAddress3(){
        return address3;
    }

    public String getName(){
        return name;
    }

    //利用序列化和反序列化进行对象的深拷贝
    public Object deepClone() throws Exception{
        //序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(this);

        //反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

    @Override
    public String toString(){
        return "name="+name+";"+address3.toString();
    }

    public static void main(String[] args) {
        try {
            Person3 person1 = new Person3(new Address3("北京朝阳"),"lulu");
            Person3 person2 = (Person3)person1.deepClone();
            System.out.println("person1==person2的值为"+(person1==person2));

            person2.setName("璐璐");
            Address3 addr = person2.getAddress3();
            addr.setAddr("山东潍坊");
            System.out.println("person1:"+person1.toString());
            System.out.println("person2:"+person2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Address3 implements Serializable{
    private String addr;

    public Address3(String addr){
        this.addr = addr;
    }

    public String getAddr(){
        return addr;
    }

    public void setAddr(String addr){
        this.addr = addr;
    }

    @Override
    public String toString(){
        return "addr="+addr;
    }

}
