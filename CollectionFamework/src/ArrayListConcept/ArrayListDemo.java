package ArrayListConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayListDemo {
    public static void main(String[] args) {
        //default class
        //dynamic array

        //default generics
        ArrayList<Object> ar =new ArrayList<Object>();
        ar.add(100);
        ar.add("Dataany Data");
        ar.add(155.54);
        ar.add(true);
        ar.add('t');
        ar.add(150);
        System.out.println(ar);

        System.out.println(ar.get(2));
       // System.out.println(ar.get(6));
      // System.out.println(ar.get(-1));
        System.out.println(ar.size());
        ar.add(400);
        ar.add("valued");

        System.out.println(ar);
        System.out.println(ar.size());

        ArrayList<Integer> numbers =new ArrayList<Integer>(Arrays.asList(18,51,45,89,56));
        System.out.println(numbers);

        ArrayList<String> pl =new ArrayList<String>(Arrays.asList("Java","php","python"));
        System.out.println(pl);
        System.out.println(pl.size());




    }
}
