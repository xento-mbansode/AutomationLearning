package com.intrefaces;
import com.intrefaces.Math; //importing package along with interface name
class mathtest implements Math {

    @Override
    public int addition(int x, int y) {
        return x+y;
    }

    @Override
    public int substration(int x, int y) {
        return x-y;
    }
}
class demoInterface extends mathtest{
    public static void main(String[] args) {
        mathtest obj=new mathtest();
        System.out.println(obj.addition(20,30));
        System.out.println(obj.substration(40,20));
    }
}