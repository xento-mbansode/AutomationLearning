package com;

class A{
    void show(){
        System.out.println("In class A");
    }
}
class B extends A{
    void display(){
        System.out.println("In class B");
    }
}
public class demoInheritance {
    public static void main(String [] args){
        B obj=new B();
        obj.show();
        obj.display();
    }
}
