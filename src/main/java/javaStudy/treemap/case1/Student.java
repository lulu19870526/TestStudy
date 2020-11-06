package javaStudy.treemap.case1;

public class Student implements Comparable<Student>{

    private String name;
    private String age;

    public Student() {
    }

    public Student(String name, String age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age.compareTo(o.age);
    }

}
