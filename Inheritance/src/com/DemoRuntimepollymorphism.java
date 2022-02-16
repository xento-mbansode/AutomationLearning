package com;
class A4{
    void show(){
        System.out.println("In A4");
    }
}
class B4 extends A4{
    @Override
    void show() {
        System.out.println("In B4");
    }
}
class C4 extends B4{
    @Override
    void show() {
        System.out.println("In C4");
    }
}
public class DemoRuntimepollymorphism {
    public static void main(String[] args) {
        A4 obj1=new A4();
        B4 obj2=new B4();
        C4 obj3=new C4();

        obj1.show();
        obj2.show();
        obj3.show();

        A4 r; //Runtime pollymorphism A refferrance varioable of base class we can assign the objects of derived class
        r=obj1;
        r.show();

        r=obj2;
        r.show();

        r=obj3;
        r.show();
    }
}
