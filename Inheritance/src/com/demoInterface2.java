package com;
//import com.intrefaces.Math;
import com.intrefaces.extraMath;
class matthtest2 implements extraMath{

    @Override
    public int addition(int x, int y) {
        return x+y;
    }

    @Override
    public int substration(int x, int y) {
        return x-y;
    }

    @Override
    public int multiplication(int x, int y) {
        return x*y;
    }

    @Override
    public int division(int x, int y) {
        return x/y;
    }
}
public class demoInterface2 {
    public static void main(String[] args) {
        matthtest2 obj=new matthtest2();

        System.out.println(obj.addition(50,100));
        System.out.println(obj.substration(55,11));
        System.out.println(obj.division(55,11));
        System.out.println(obj.multiplication(11,11));
    }
}
