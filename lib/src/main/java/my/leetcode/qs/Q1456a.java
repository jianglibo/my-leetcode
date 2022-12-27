package my.leetcode.qs;

import java.util.Set;

public class Q1456a {
	    public int maxVowels(String s, int k) {
		int res = 0, sofar = 0;
		var vowels = Set.of('a', 'e', 'i', 'o', 'u');

		for(int i=0; i<k; i++) {
			if(vowels.contains(s.charAt(i))){
				sofar++;
			}
		}
		res = sofar;
		for(int i=0, j=k; res < k &&  j < s.length();i++, j++) {
			if (vowels.contains(s.charAt(i))) {
				sofar--;
			}
			if (vowels.contains(s.charAt(j))) {
				sofar++;
			}
			res = Math.max(res, sofar);
		}
        return res;
    }
}

