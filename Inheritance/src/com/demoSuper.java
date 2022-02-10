package com;
class DemoA{
    int i;
    DemoA(){
        i=10;
    }
}
class DemoB extends DemoA{
    int i;
    DemoB(){
        i=20;
    }

    void add(){
        System.out.println(i+super.i); // super keyword is used to access the memebrs of base class
    }
}
public class demoSuper {
    public static void main(String[] args) {
        DemoB obj=new DemoB();
        obj.add();
    }
}
