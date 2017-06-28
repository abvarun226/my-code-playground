package com.DataStructures.Stack;

/**
 * Created by bharghava on 20/6/17.
 */

interface StackIface {
    void push(int item);
    int pop();
    boolean isEmpty();
    default void clear() {
        System.out.println("clear() method not implemented!");
    }
}

class Stack implements StackIface {
    private int tos;
    private int[] stck;

    Stack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public void push(int item) {
        if(tos == stck.length - 1) {
            System.out.println("Increasing the size of the stack...");
            int[] temp = new int[stck.length * 2];
            for(int i=0; i<stck.length; i++) temp[i] = stck[i];
            stck = temp;
        }
        stck[++tos] = item;
    }

    public int pop() {
        if(this.isEmpty()) {
            System.out.println("Stack underflow!!!");
            return 0;
        }
        return stck[tos--];
    }

    public boolean isEmpty() {
        if(tos < 0) {
            return true;
        }
        return false;
    }
}

public class StackTest {
    public static void main(String[] args) {
        StackIface obj1 = new Stack(10);
        StackIface obj2 = new Stack(15);
        for(int i=1; i<15; i++) {
            obj1.push(i);
        }
        for(int i=11; i<30; i++) {
            obj2.push(i);
        }

        System.out.println("\nObj1");
        while(!obj1.isEmpty()) {
            System.out.println(obj1.pop());
        }
        System.out.println("\nObj2");
        while(!obj2.isEmpty()) {
            System.out.println(obj2.pop());
        }
        obj2.clear();
    }
}
