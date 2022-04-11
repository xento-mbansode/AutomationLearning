package ArrayListConcept;

import java.util.ArrayList;
import java.util.Arrays;

public class SortAndStar {
    public static void main(String[] args) {
        String[] s= {"bitcoin", "take", "over", "the", "world", "maybe", "who", "knows", "perhaps"};
        Arrays.sort(s);
        char[] c = s[0].toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c.length - 1; i++) {
            sb.append(String.valueOf(c[i]));
            sb.append("***");
        }
        sb.append(c[c.length-1]);

        System.out.println(sb.toString());
     }
  }

