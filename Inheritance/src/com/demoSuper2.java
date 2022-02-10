package com;
class DemoA1{
    int i;
    DemoA1(int x){
        i=x;
    }
}
class DemoB1 extends DemoA1{
    DemoB1(int a, int b){
        super(a); // super is used to call constructor of base class with parameter
        i=b;
    }
    void demoAdd(){
        System.out.println(i+super.i);
    }
}
public class demoSuper2 {
    public static void main(String[] args) {
        DemoB1 obj=new DemoB1(10,20); // passed parameters
        obj.demoAdd();
    }
}
