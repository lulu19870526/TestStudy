package test.clone;

/**
 * 深克隆中，无论原型对象的成员变量是值类型还是引用类型，都将复制一份给克隆对象，
 * 深克隆将原型对象的所有引用对象也复制一份给克隆对象。
 * 简单来说，在深克隆中，除了对象本身被复制外，对象所包含的所有成员变量也将复制。
 */
public class Person2 implements Cloneable {
    private Address2 address2;
    private String name;

    public Person2(Address2 address2,String name){
        this.address2 = address2;
        this.name = name;
    }

    public void setAddress2(Address2 address2){
        this.address2 = address2;
    }

    public void setName(String name){
        this.name = name;
    }

    public Address2 getAddress2(){
        return address2;
    }

    public String getName(){
        return name;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person2 person = (Person2)super.clone();
        //手动对address属性进行clone，并赋值给新的person对象
        person.address2 = (Address2) address2.clone();
        return person;
    }

    @Override
    public String toString(){
        return "name="+name+";"+address2.toString();
    }

    public static void main(String[] args){
        try {
            Person2 person1 = new Person2(new Address2("北京朝阳"),"lulu");
            Person2 person2 = (Person2)person1.clone();
            System.out.println("person1==person2的值为"+(person1==person2));

            person2.setName("璐璐");
            Address2 addr = person2.getAddress2();
            addr.setAddr("山东潍坊");
            System.out.println("person1:"+person1.toString());
            System.out.println("person2:"+person2.toString());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}

class Address2 implements Cloneable{
    private String addr;

    public Address2(String addr){
        this.addr = addr;
    }

    public String getAddr(){
        return addr;
    }

    public void setAddr(String addr){
        this.addr = addr;
    }

    //Object.clone()方法是浅拷贝，而不是深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Override
    public String toString(){
        return "addr="+addr;
    }

}
