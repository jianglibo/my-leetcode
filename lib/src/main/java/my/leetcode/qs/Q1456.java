package my.leetcode.qs;

public class Q1456 {
	    public int maxVowels(String s, int k) {
		String vowels = "aeiou";
		int res = 0, sofar = 0;

		for(int i=0; i<k; i++) {
			if(vowels.indexOf(s.charAt(i)) != -1){
				sofar++;
			}
		}
		res = sofar;
		for(int i=0, j=k; res < k &&  j < s.length();i++, j++) {
			if (vowels.indexOf(s.charAt(i)) != -1) {
				sofar--;
			}
			if (vowels.indexOf(s.charAt(j)) != -1) {
				sofar++;
			}
			res = Math.max(res, sofar);
		}
        return res;
    }
}
