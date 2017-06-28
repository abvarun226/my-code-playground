package com.abvarun226;

class Stack {
    private int[] stck = new int[10];
    private int tos;

    Stack() {
        tos = -1;
    }

    public void push(int item) {
        if(tos >= 9) {
            System.out.println("StackTest overflow");
        } else {
            stck[++tos] = item;
        }
    }

    public int pop() {
        if(tos < 0) {
            System.out.println("StackTest Underflow");
            return 0;
        } else {
            return stck[tos--];
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        for(int i=0; i < 10; i++) {
            stack1.push(i);
        }
        for(int i=10; i < 21; i++) {
            stack2.push(i);
        }

        for(int i=0; i < 10; i++) {
            System.out.println(stack1.pop());
        }
        for(int i=0; i < 11; i++) {
            System.out.println(stack2.pop());
        }
    }
}