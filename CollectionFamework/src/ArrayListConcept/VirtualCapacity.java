package ArrayListConcept;
import java.util.ArrayList;

public class VirtualCapacity {
    public static void main(String[] args) {

        ArrayList<Object> ar=new ArrayList<Object>();
        System.out.println(ar.size()); //physical capacity is 0 zero
        //ar.add(100);
        System.out.println(ar.size()); //physical capacity is 1 zero

        //default virtual capacity is 10 for ArrayList, and can be change like as below
        // ArrayList<Object> ar=new ArrayList<Object>(20);

        ar.add("A");
        ar.add("B");
        ar.add("C");
        ar.add(1,"D");
        ar.add(2,"E");
        System.out.println(ar);
    }
}
