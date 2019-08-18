package com.ahscuml.mycollections;

import java.util.LinkedList;

/**
 * @author ahscuml
 * @date 2019/4/16
 * @time 0:31
 */
public class test {
    public static void main(String[] args) {
        myLinkedList<Integer> linkedList = new myLinkedList<>();
        linkedList.add(5);
        linkedList.add(4);
        System.out.println(linkedList.getSize());
        linkedList.remove(5);
        linkedList.add(0,1);
        System.out.println(linkedList.getSize());
        linkedList.remove(4);
        System.out.println(linkedList.getSize());
    }
}
