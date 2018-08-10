package test;


import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by on 2017/12/16.
 */
public class TestJar {

    public static void main(String args[]) {
        try {
            JarFile jarFile = new JarFile("D:/fastjson-1.2.6.jar");
            Enumeration enu = jarFile.entries();
            while (enu.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) enu.nextElement();
                String name = jarEntry.getName();
                if (name.endsWith(".class")) {
                    System.out.println("name=" + name);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
