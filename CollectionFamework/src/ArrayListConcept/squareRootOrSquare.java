package ArrayListConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class squareRootOrSquare {

    public static void main(String[] args) {
        int[] input = new int[] { 4, 3, 9, 7, 2, 1 };
        ArrayList<Integer> aList= new ArrayList<Integer>(input.length);
        ArrayList<Integer> finalList=new ArrayList<>();
        for (int i : input)
        {
            aList.add(i);
        }
        System.out.println(aList);
        for(Integer no: aList){
            double sqrt=Math.sqrt(no);
            System.out.println(((sqrt - Math.floor(sqrt)) == 0));
            if(((sqrt - Math.floor(sqrt)) == 0)){
                int value=(int)sqrt;
                finalList.add(value);

            }else{
                no=no*no;
                finalList.add(no);
                System.out.println(no);
            }
            System.out.println(finalList);
            //return finalList;

        }

    }
}
