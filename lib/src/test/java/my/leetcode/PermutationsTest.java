package my.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class PermutationsTest {

	@Test
	void t1() {
		Permutations<Integer> perm =
				new Permutations<Integer>(new Integer[] {0,1,2,3,4,5});
		int count = 0;
		while (perm.hasNext()) {
			System.out.println(Arrays.toString(perm.next()));
			count++;
		}
		System.out.println("total: " + count);
	}
}
