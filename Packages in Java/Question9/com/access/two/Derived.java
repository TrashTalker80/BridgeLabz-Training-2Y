package com.access.two;

import com.access.one.Base;

public class Derived extends Base {
    public void testAccessibility() {
        System.out.println("Testing accessibility in subclass from different package:\n");
        
        publicMethod();
        System.out.println("Public method: Accessible\n");
        
        protectedMethod();
        System.out.println("Protected method: Accessible\n");
        
        System.out.println("Default method: NOT Accessible (different package)");
        System.out.println("Private method: NOT Accessible (private to Base class)");
    }
}
