package com.access.one;

public class Base {
    public void publicMethod() {
        System.out.println("Public method - Accessible everywhere");
    }

    protected void protectedMethod() {
        System.out.println("Protected method - Accessible in subclass");
    }

    void defaultMethod() {
        System.out.println("Default method - Accessible within same package only");
    }

    private void privateMethod() {
        System.out.println("Private method - Accessible within class only");
    }

    public void testAllMethods() {
        publicMethod();
        protectedMethod();
        defaultMethod();
        privateMethod();
    }
}
