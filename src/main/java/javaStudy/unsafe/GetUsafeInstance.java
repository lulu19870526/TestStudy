package javaStudy.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class GetUsafeInstance {

    public static Unsafe getUnsafeInstance(){
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe us = (Unsafe) f.get(null);
            return us;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
