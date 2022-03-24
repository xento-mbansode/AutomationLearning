package ArrayListConcept;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateString {

    static void findDuplicateCharacters(String str){

        System.out.println("Given string is: " +str);
        String strArray[]=str.split(" ");
      List<String> list= new ArrayList<String>();
        list=Arrays.asList(strArray);
        System.out.println(list);
        List<String> finalList = list;
        List<String> duplicateList=list.stream().filter(e -> Collections.frequency(finalList, e) > 1).distinct().collect(Collectors.toList());
        System.out.println(duplicateList);
    }

    public static void main(String[] args) {
        findDuplicateCharacters("I am am learning java java java");
    }
}
