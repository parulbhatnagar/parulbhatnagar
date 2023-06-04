package study.concurrency;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentMapRunner {
    public static void main(String[] args) {

        //Map<Character, LongAdder> occurrence = new Hashtable<>();
        ConcurrentHashMap<Character, LongAdder> occurrence = new ConcurrentHashMap<>();
                String str = "ABCD ABCD ABCD";

        for (char chr :
                str.toCharArray()) {
            occurrence.computeIfAbsent(chr,character -> new LongAdder()).increment();
            /*
            LongAdder longAdder = occurrence.get(chr);
            if(longAdder == null){
                longAdder = new LongAdder();
            }
            longAdder.increment();
            occurrence.put(chr,longAdder);*/
        }

        System.out.println(occurrence);
    }
}
