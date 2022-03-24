package ArrayListConcept;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayListMethods {
    public static void main(String[] args) {
        ArrayList<String> ar1=new ArrayList<String>();
        ar1.add("java");
        ar1.add("php");
        ar1.add("ruby");
        ar1.add("js");
        System.out.println("ar1 list" +ar1);

        ArrayList<String> ar2=new ArrayList<String>();
        ar2.add("Development");
        ar2.add("Testing");
        ar2.add("DevOps");
        System.out.println("ar2 list" +ar2);

        ar1.addAll(ar2);
        System.out.println("New ar1 list" +ar1);

//        ar1.clear();
//        System.out.println(ar1);

        ArrayList<String> cloneList= (ArrayList<String>) ar1.clone();
        System.out.println(cloneList);

        //contains
        System.out.println(ar1.contains("DevOps"));

        //indexOf
        System.out.println(ar1.indexOf("ruby")>0);

        ArrayList<String> myList=new ArrayList<String>(Arrays.asList("Mak","Nikhil","Rahul","Mak","amit","Prateek","Mak"));
        System.out.println(myList);
        int i=myList.lastIndexOf("Mak");
        System.out.println(i);

        //remove
        myList.remove(1);
        System.out.println(myList);
        myList.remove("Mak");
        System.out.println(myList);

        //removeIF
        ArrayList<Integer> numbers=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        System.out.println(numbers);
        numbers.removeIf(num ->num%2==0);
        //numbers.removeIf(num ->num%2!=0);
        System.out.println("removed the element based on condition");
        System.out.println(numbers);

        //Singleton
        ArrayList<String> myList1=new ArrayList<String>(Arrays.asList("Mak","Nikhil","Rahul","Mak","amit","Prateek","Mak"));
        System.out.println(myList1);

        myList1.retainAll(Collections.singleton("Mak"));
        System.out.println(myList1);

        //sublist
        ArrayList<Integer> numbers1=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        System.out.println(numbers1);

        ArrayList<Integer> sublist=new ArrayList<Integer>(numbers1.subList(1,8));
        System.out.println(sublist);

        //ArrayList to Array
        ArrayList<String> newList=new ArrayList<String>(Arrays.asList("Mak","Nikhil","Rahul","Mak","amit","Prateek","Mak"));
        Object arr[]=newList.toArray();
        System.out.println(Arrays.toString(arr));
        for(Object o: arr){
            System.out.println((String)o);
        }
    }

}
