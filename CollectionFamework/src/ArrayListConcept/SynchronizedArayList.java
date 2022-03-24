package ArrayListConcept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedArayList {
    public static void main(String[] args) {

        List<String> plNames= Collections.synchronizedList(new ArrayList<String>());
        plNames.add("java");
        plNames.add("c++");
        plNames.add("python");
        plNames.add("ruby");

        // add, remove - we don't need explicit synchronization
        // to fetch/traverse the values from this list -- we have to use explicit synchronization
        synchronized (plNames){
            Iterator<String> it=plNames.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }

        // copyOnWriteArrayList --- its a class: thread-safe/synchronized already

        CopyOnWriteArrayList<String> empList = new CopyOnWriteArrayList<String>();
        empList.add("Mak");
        empList.add("Rahul");
        empList.add("Aanand");

        // we don't need explicit synchronization for any operation: add/remove/traverse
        Iterator<String> it= empList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}

