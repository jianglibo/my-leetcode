package my.leetcode.qs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://bitbucket.org/StableSort/play/src/master/src/com/stablesort/stringmatch/KnuthMorrisPratt.java

public class Q1316 {

		/**
	 * creates an array of length pattern.length()+1
	 * @param pattern "abcxxxabcyyy"
	 * @return [-1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 0, 0, 0]
	 */
	public static int[] calcPrefixLen(String pattern) {
		int patternLen = pattern.length();
		int[] ar = new int[patternLen + 1];
		ar[0] = -1;
		ar[1] = 0;

		int prefixLen = 0;
		int i = 1;
		
		while (i < patternLen) {			
			if (pattern.charAt(prefixLen) == pattern.charAt(i)) { 
				prefixLen++;
				i++;
				ar[i] = prefixLen;
				
			} else if (prefixLen > 0) {
				prefixLen = ar[prefixLen]; // note  that we do not increment i here
				
			} else {
				i++;
				ar[i] = 0; // 'prefixLen' reached 0, so save that into ar[] and move forward
			}
		}
		
		return ar;
	}
	
	/**
	 * implementation is based on the pseudo code from Wikipedia: https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static List<Integer> search(String text, String pattern) {
		int t = 0; // the position of the current character in text
		int p = 0; // the position of the current character in pattern
		
		int tLen = text.length();
		int pLen = pattern.length();
		
		List<Integer> matches = new ArrayList<>();
		int[] prefixLen = calcPrefixLen(pattern);
		
		while (t < tLen) {
			if (pattern.charAt(p) == text.charAt(t)) {				
				p++;
				t++;
				
				if (p == pLen) {
					// occurrence found, if only first occurrence is needed then you could halt here
					matches.add(t-p);
					p = prefixLen[p]; // reset
				}				
			} else {
				p = prefixLen[p];
				if (p < 0) {
					t++;
					p++;
				}
			}
		}
		
		return matches;
	}

	public int distinctEchoSubstrings(String s) {
	Set<String> set = new HashSet<>();
	for (int len = 1; len <= s.length() / 2; len++) {
		for (int l = 0, r = len, count = 0; l < s.length() - len; l++, r++) {
			if (s.charAt(l) == s.charAt(r)) count++;
			else count = 0;

			if (count == len) {
				set.add(s.substring(l - len + 1, l + 1));
				count--;
			}
		}
	}

	return set.size();
}

	 
	public static void main(String[] args) {
		String text = "---abcxxxab------abcxxxabcy---";
		String pattern = "abcxxxabcy";
		
		System.out.println("text="+text);
		System.out.println("pattern=" + pattern);
		
		System.out.println(search(text, pattern));
	}
	
}
