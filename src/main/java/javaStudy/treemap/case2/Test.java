package javaStudy.treemap.case2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {
        /**
         * 自定义一个比较器StudentComparator，比较student下的age大小
         */
        StudentComparator studentComparator = new StudentComparator();
        TreeMap<Student, String> treeMap = new TreeMap<>(studentComparator);
        Student student1 = new Student("zs", "10");
        Student student2 = new Student("ls", "12");
        Student student3 = new Student("ww", "11");
        Student student4 = new Student("zl", "15");
        treeMap.put(student1,"beijing");
        treeMap.put(student2,"shenzhen");
        treeMap.put(student3,"hangzhou");
        treeMap.put(student4,"guangzhou");

        Set<Map.Entry<Student, String>> entries = treeMap.entrySet();
        for(Map.Entry<Student, String> entry : entries) {
            System.out.println(entry.getKey() + "==========" + entry.getValue());
        }
    }
}
