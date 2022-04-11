package ArrayListConcept;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PokerHand {

  public static boolean CheckIfFlush(String[] cards) {
      ArrayList<String> list = new ArrayList<String>(Arrays.asList(cards));
      System.out.println(list);
      Map<Character,Integer>charMap = new HashMap<Character,Integer>();
      char[] chars = list.toString().toCharArray();
      for (char c : chars) {
          if(Character.isAlphabetic(c)){
              if(charMap.containsKey(c)){
                  charMap.put(c,charMap.get(c) +1);
              }else{
                  charMap.put(c,1);
              }
          }
//          System.out.println(charMap);
//          System.out.println("Keys: "+charMap.keySet());
//          System.out.println("Values: "+charMap.values());

          //System.out.println(charMap.size());
          }
      System.out.println("Keys: "+charMap.keySet());
      System.out.println("Values: "+charMap.values());
      if(charMap.containsKey('S') && charMap.containsValue(5)){
          System.out.println(true);
          return true;
       }if(charMap.containsKey('H') && charMap.containsValue(5)){
          System.out.println(true);
          return true;
      }if(charMap.containsKey('C') && charMap.containsValue(5)){
          System.out.println(true);
          return true;
      }if(charMap.containsKey('D') && charMap.containsValue(5)){
          System.out.println(true);
          return true;
      }
      return false;

  }

    public static void main(String[] args){

       CheckIfFlush(new String[]{"AS", "3S", "10S", "KS", "4S"});
       CheckIfFlush(new String[]{"AD", "4S", "7H", "KC", "5S"});
       CheckIfFlush(new String[]{"AD", "4S", "10H", "KC", "5S"});
       CheckIfFlush(new String[]{"QD", "4D", "10D", "KD", "5D"});

    }
}
