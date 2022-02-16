package com;
import com.intrefaces.extraMath;
class Test3 implements extraMath{
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
public class DemoInterface3 {
    public static void main(String[] args) {
        Test3 tObj;
        tObj=new Test3();
        System.out.println(tObj.addition(1,52));
        System.out.println(tObj.multiplication(50,965));
    }
}