package com;
class base{
    int i;
    void setI(int x){
        i=x;
    }
}
class child extends base{
    int j;
   void setJ(int y) {
         j=y;
    }
    void add(){
        System.out.println(i+j);
    }
}
public class demoInheritance2 {
    public static void main(String [] args){
        child obj=new child();
        obj.setI(10);
        obj.setJ(20);
        obj.add();
    }
}
