package com.degang.jvm_practice.oom;

/**
 * VM Args:-Xss128k
 * 虚拟机栈和本地方法栈测试
 * throw "Exception in thread "main" java.lang.StackOverflowError"
 *
 * Created by degang on 2018/11/13
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
