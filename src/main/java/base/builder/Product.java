package base.builder;

import java.util.ArrayList;

/**
 * @Author: zengqx
 * @Date: 2023/2/9 14:51
 */
public class Product {

    ArrayList<String> parts = new ArrayList<String>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println(parts);
    }
}
