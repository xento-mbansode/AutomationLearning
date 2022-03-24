package HashMapConcept;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapBasics {
    public static void main(String[] args) {
        //no order - indexing
        //stores values -- Key-Value <k,v>
        //key can not be duplicate
        //can store n number of values but only one null key
        //hasmap is not thread-safe - un-synchronized


        HashMap<String, String> captialMap= new HashMap<String, String>();
        captialMap.put("India","Delhi");
        captialMap.put("USA","Washington DC");
        captialMap.put("UK","London");
        captialMap.put(null,"Berlin");
        captialMap.put(null,"LA");
        captialMap.put("Russia",null);
        captialMap.put("France",null);

        System.out.println(captialMap.get("USA"));
        System.out.println(captialMap.get(null));
        System.out.println(captialMap.get("France"));

        captialMap.remove("France");

        // iterator: over the keys: by using keySet()

        Iterator<String> it =captialMap.keySet().iterator();
        while (it.hasNext()){
            String key=it.next();
            String value=captialMap.get(key);
            System.out.println("Key = " +key+ " and value = " +value);

        }

        // iterator: over the set (pair): by using entrySet
        System.out.println("----------------");
           Iterator<Map.Entry<String,String>> it1=captialMap.entrySet().iterator();
           while (it1.hasNext()){
               Map.Entry<String,String> entry=it1.next();
               System.out.println("Key = " +entry.getKey() + " and Value = " +entry.getValue() );
           }
         //iterate hashmap using foreach and lambda
        System.out.println("----------------");
        captialMap.forEach((k,v) -> System.out.println("Key = "+ k +" and Value = "+v));

    }
}
