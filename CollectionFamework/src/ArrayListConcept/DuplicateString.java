package ArrayListConcept;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateString {

    static void findDuplicateCharacters(){

        System.out.println("Given string is: " + "I am am learning java java java");
        String[] strArray = "I am am learning java java java".split(" ");
        List<String> list= new ArrayList<String>();
        list=Arrays.asList(strArray);
        System.out.println(list);
        List<String> finalList = list;
        List<String> duplicateList=list.stream().filter(e -> Collections.frequency(finalList, e) > 1).distinct().collect(Collectors.toList());
        System.out.println(duplicateList);
      }

    public static void main(String[] args) {
        findDuplicateCharacters();
    }
}
