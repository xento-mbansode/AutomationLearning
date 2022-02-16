package com;

abstract class absrt{
    abstract void show();

    void display(){
        System.out.println("In abstarct class");
    }
}
class bsrt extends absrt{

    @Override
    void show() {
        System.out.println("Using abstract function");
    }
    void add(){
        System.out.println(10+20);
    }
}
public class DemoAbstract {
    public static void main(String[] args) {
        bsrt obj=new bsrt();
        obj.display();
        obj.show();
        obj.add();
    }
}
