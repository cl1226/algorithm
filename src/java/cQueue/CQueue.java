package cQueue;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class CQueue {

    Stack<Integer> first = null;
    Stack<Integer> second = null;

    public CQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void appendTail(int value) {
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        first.push(value);
    }

    public int deleteHead() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        if (second.isEmpty()) {
            return -1;
        }
        return second.pop();
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
        System.out.println(obj.deleteHead());
    }

}
