package com.ahscuml.container;

/**
 * @author ahscuml
 * @date 2019/1/7
 * @time 11:09
 */
public interface List extends Collection{
    void set(int index, Object obj);
    Object remove(int index);
}
