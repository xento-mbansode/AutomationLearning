package ArrayListConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateElements {
    public static void main(String[] args) {

        ArrayList<Integer> numbers=new ArrayList<Integer>(Arrays.asList(1,2,1,4,5,6,7,2,9,10,12,12,13,14,15,10,17,8,9,2));

        //1. LinkedHashSet
        System.out.println(numbers);
        LinkedHashSet<Integer> linkedHashSet= new LinkedHashSet<Integer>(numbers);
        ArrayList<Integer>numberListWhitoutDuplicates =new ArrayList<Integer>(linkedHashSet);
        System.out.println(numberListWhitoutDuplicates);


        //2. using stream
        ArrayList<Integer> marksList=new ArrayList<Integer>(Arrays.asList(1,2,1,4,5,6,7,2,9,10,12,12,13,14,15,10,17,8,9,2));
        List<Integer> marksListUnique =marksList.stream().distinct().collect(Collectors.toList());
        System.out.println(marksListUnique);


    }
}
