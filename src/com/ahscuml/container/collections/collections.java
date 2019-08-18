package com.ahscuml.container.collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ahscuml
 * @date 2019/1/7
 * @time 10:01
 */
public class collections {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1, 2, 3, 4, 5, 6);
        System.out.println(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        Collections.replaceAll(arrayList, 1, 10);
        System.out.println(arrayList);
        Collections.swap(arrayList, 1, 2);
        System.out.println(arrayList);
    }
}
