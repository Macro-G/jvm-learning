package com.macrog.demo;

/**
 * @author guohong
 * @date 2018/10/18
 */
public class ClazzLoadTest {
    public static int A = 1;

    static {
        A = 2;
    }
    static class Sub extends ClazzLoadTest {

        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
