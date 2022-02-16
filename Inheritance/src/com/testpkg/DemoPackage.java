package com.testpkg;
class testp{
    public void show(){
        System.out.println("Inside package");
    }
}
public class DemoPackage {
    public static void main(String[] args) {
        testp obj=new testp();
        obj.show();
    }

}
