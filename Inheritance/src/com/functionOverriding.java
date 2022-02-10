package com;
class demoBase{
    void show(){
        System.out.println("In the demoBase class");
    }
}
class demoChild extends demoBase{
    void show(){
        System.out.println("In the demoChild class");
    }
    void show(String s){
        System.out.println(s);
    }
}
public class functionOverriding {
    public static void main(String[] args) {
        demoChild obj=new demoChild();
        obj.show(); //When base class and derived class has same function name with same parameters then its called function overriding
                    //when called the overrided function/method with the object of derived class then always derived class function get executed
        obj.show();
        obj.show("Hello from demoChild");
    }
}
