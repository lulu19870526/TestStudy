package test.clone;


/**
 * 在浅克隆中，如果原型对象的成员变量是值类型，将复制一份给克隆对象；
 * 如果原型对象的成员变量是引用类型，则将引用对象的地址复制一份给克隆对象，
 * 也就是说原型对象和克隆对象的成员变量指向相同的内存地址。
 *
 * 在复制得到的新对象对该引用类型属性内容进行修改，原始对象响应的属性内容也会发生变化
 */
public class Person1 implements Cloneable {
    private Address1 address1;
    private String name;

    public Person1(Address1 address1,String name){
        this.address1 = address1;
        this.name = name;
    }

    public void setAddress1(Address1 address1){
        this.address1 = address1;
    }

    public void setName(String name){
        this.name = name;
    }

    public Address1 getAddress1(){
        return address1;
    }

    public String getName(){
        return name;
    }

    //Object.clone()方法是浅拷贝，而不是深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString(){
        return "name="+name+";"+address1.toString();
    }

    public static void main(String[] args){
        try {
            Person1 person1 = new Person1(new Address1("北京朝阳"),"lulu");
            Person1 person2 = (Person1)person1.clone();
            System.out.println("person1==person2的值为"+(person1==person2));

            person2.setName("璐璐");
            Address1 addr = person2.getAddress1();
            addr.setAddr("山东潍坊");
            System.out.println("person1:"+person1.toString());
            System.out.println("person2:"+person2.toString());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}

class Address1{
    private String addr;

    public Address1(String addr){
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
