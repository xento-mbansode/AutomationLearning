package com;
class A3{
    int i;
    A3(){
        i=10;
    }
}

class B3 extends A3{
    //int j;
    int i;
    B3(){
        //j=30;
        i=50;
    }

    void add(){
        System.out.println(i+i);
    }
}

public class DemoConstructor2 {
    public static void main(String[] args) {
    B3 obj = new B3();
    obj.add();
    }
}
