package my.leetcode.qs;

import java.util.HashMap;
import java.util.Map;

public class Q2156 {

	Map<Integer, Long> pws = new HashMap<>();

	int search(String s, int power, int modulo, int k, int hashValue) {
		long h = hash(s,0,k,power,modulo);
		
		if (h == hashValue) {
			return 0;
		}
		for(int i=k; i<s.length(); i++) {
			h = (h - (val(s.charAt(i-k)) % modulo) + (((val(s.charAt(i)) % modulo) * pw(k - 1, power, modulo))) % modulo) % modulo;
			if (h == hashValue ) {
				return i - k + 1;
			}
		}
		return -1;
	}


	int val(char c) {
		return c - 96;
	}

	long hash(String s, int start, int k,int power, int modulo) {

        long h = 0;
        for(int i=start;i<k+start && i<s.length();i++) {
		int one = val(s.charAt(i)) % modulo;
		h += one * pw(i - start, power, modulo);
	}
        return h % modulo;
}

	long pw(int times, int power, int modulo) {
	long v = pws.computeIfAbsent(times, k -> {
		if (pws.containsKey(times - 1)) {
			return (pws.get(times - 1) * power) % modulo;
		} else {
		long n = 1;
		for(int i=0; i< times; i++) {
			n = (power * n) % modulo;
		}
		return n;
		}
		});	
	return v;
	}	
}
