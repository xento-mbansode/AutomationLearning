package ArrayListConcept;

import java.util.ArrayList;

public class GenericArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> marksList= new ArrayList<Integer>();
        marksList.add(100);
        marksList.add(156);

        System.out.println(marksList);

        ArrayList<String> studentNames= new ArrayList<String>();
        studentNames.add("Makrand");
        studentNames.add("Rahul");

        System.out.println(studentNames);
    }
}
