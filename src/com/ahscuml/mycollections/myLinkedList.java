package com.ahscuml.mycollections;

/**
 * @author ahscuml
 * @date 2019/4/16
 * @time 0:18
 */
public class myLinkedList<E> {
    Node<E> first = null;
    Node<E> last = null;
    int size = 0;

    /**
     * 添加节点(注意处理添加第一个节点的情况)
     * */
    public boolean add(E val) {
        Node<E> node = new Node(last, val, null);
        if (last == null) {
            last = node;
            first = node;
        } else {
            last.next = node;
        }
        size++;
        return true;
    }

    /**
     * 按照index添加节点
     * */
    public void add(int index, E val) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("输入错误");
        }
        Node<E> cur = node(index);
        if (index == 0 || index == size) {
            add(val);
        } else {
            Node<E> node = new Node<>(cur.pre, val, cur);
        }
    }

    /**
     * 返回当前index的节点
     * */
    private Node node(int index) {
        Node<E> cur = new Node(null, -1, null);
        if (index < (size << 1)) {
            cur = first;
            while (index-- != 0) {
                cur = cur.next;
            }
        } else {
            cur = last;
            while (index++ != size) {
                cur = cur.pre;
            }
        }
        return cur;
    }

    /**
     * 删除当前值的节点
     * */
    public boolean remove(E val) {
        Node<E> cur = first;
        boolean isRemoved = false;
        while (cur != null) {
            if (cur.val == val) {
                // 如果是头结点
                if (cur.equals(first)) {
                    first = cur.next;
                } else {
                    cur.next.pre = cur.pre;
                    cur.pre.next = cur.next;
                    // 如果是尾节点
                    if (cur.next == null) {
                        last = cur.pre;
                    }
                    cur = null;
                }
                isRemoved = true;
                size--;
                break;
            }
            cur = cur.next;
        }
        cur = null;
        return isRemoved;
    }

    /**
     * 获取当前容量
     * */
    public int getSize() {
        return size;
    }

    /**
     * Node节点的创建
     * */
    private class Node<E> {
        Node<E> pre;
        Node<E> next;
        E val;

        Node(Node<E> pre, E val, Node<E> next) {
            this.pre = pre;
            this.val = val;
            this.next = next;
        }
    }
}
