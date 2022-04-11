package ArrayListConcept;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class whoLikesIt {
    String str;
    public static String Solution(String... names){
        ArrayList<String> nameList= new ArrayList<String>(Arrays.asList(names));
        System.out.println(nameList);
        Iterator<String> it=nameList.iterator();
        System.out.println(nameList.size());
        if(nameList.size()==0){
            System.out.println("no one likes this");
            return "no one likes this";
        }if(nameList.size()==1){
            //System.out.println(nameList.indexOf(0));
            System.out.println(nameList.get(0)+" likes this");
        }if(nameList.size()==2){
            System.out.println(nameList.get(0)+ " and " +nameList.get(1) +" likes this");
            return nameList.get(0)+ " and " +nameList.get(1) +" likes this";
        }if(nameList.size()==3){
            System.out.println(nameList.get(0)+", "+ nameList.get(1)+" and " +nameList.get(2) +" likes this");
            return nameList.get(0)+", "+ nameList.get(1)+" and " +nameList.get(2) +" like this";
        }if(nameList.size()>=4){
            int no=nameList.size()-2;
            System.out.println(nameList.get(0)+", "+ nameList.get(1)+" and "+no+ " others like this");
            return nameList.get(0)+", "+ nameList.get(1)+" and "+no+ " others likes this";
        }

        return null;
    }
    public static void main(String[] args) {
       Solution();
       Solution("Peter");
       Solution("Jacob", "Alex");
       Solution("Max", "John", "Mark");
       Solution("Alex", "Jacob", "Mark", "Max");
    }
}
