package com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ATMTransaction {
    public static void main(String[] args) {
        int n=1207;
//        int reminder;
//        int result;
//        int sum;
//        reminder=n%500;
//        result=n/500;
//        System.out.println(reminder%100);
//        System.out.println(result);
        if(n < 10 || n > 1500 || n%10 != 0) {
            //return -1;
            System.out.println(-1);
        }
        ArrayList<Integer> dollars= new ArrayList<>(Arrays.asList(500,200,100,50,20,10));
        System.out.println(dollars);
        int count=0;
        for (Integer d: dollars) {
          count +=n/d;
          n%=d;
        }
        //return count;
        System.out.println(count);
    }
}
