package com;

class A1{
    A1(){
        System.out.println("In A1 constructor");
    }
}

    class B1 extends A1{
        B1(){
            System.out.println("In B1 constructor");
        }
    }
    class C1 extends B1{
    C1(){
        System.out.println("In C1 constructor");
     }
    }

public class DemoConstructor {
    public static void main(String[] args) {
        C1 obj=new C1();
    }

}
