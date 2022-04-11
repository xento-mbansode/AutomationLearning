package ArrayListConcept;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIteration {
    public static void main(String[] args) {
        ArrayList<String> studentList=new ArrayList<String>();
        studentList.add("Mark");
        studentList.add("Amit");
        studentList.add("Rahul");
        studentList.add("Prateek");

        //typical for loop
        for (int i=0;i<studentList.size(); i++){
            System.out.println(studentList.get(i));
        }

        System.out.println("--------------");
        //for each loop
        for(String s: studentList){
            System.out.println(s);
          }

        System.out.println("--------------");
        // streams lambda
        System.out.println("using stream with lambda function");
        studentList.stream().forEach(ele -> System.out.println(ele));

        // iterator

        System.out.println("--------------");
        System.out.println("using iterator");

        Iterator<String> it=studentList.iterator();
        while(it.hasNext()){

                        //System.out.println(it.hasNext());
            System.out.println(it.next());
           }

    }
}
