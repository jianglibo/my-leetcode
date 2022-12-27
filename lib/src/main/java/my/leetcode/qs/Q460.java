package my.leetcode.qs;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Q460 {
    static class Ckey {
        
        Ckey(Integer key, Integer cnt) {
            this.key = key;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object k) {
            if (k instanceof Ckey) {
                return key == ((Ckey)k).key;
            } else {
                return false;
            }
        }
        @Override
        public int hashCode() {
            return key;
        }
        public int key;
        public int cnt;
    }
    
    SortedMap<Ckey, Integer> frequencies;
    Map<Integer, Integer> cache;
    
    int capacity;

    public  Q460(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.frequencies = new TreeMap<>((a,b) -> a.cnt - b.cnt);
        
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            // Ckey ck = frequencies.get(key);

            // return cv.key;
            return cache.get(key);
        }
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            // cache.put(key, new Ckey(value, 1));
        } else {
            // Ckey cv = cache.get(key);
            // cv.key = value;
            // cv.cnt++;
        }
    }	
}
