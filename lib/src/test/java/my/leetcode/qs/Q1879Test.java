package my.leetcode.qs;

import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q1879Test {
		int[] a1 = {1, 0, 3, 7, 9, 18, 22, 5, 7, 45};
		int[] a2 = {5, 3, 4, 89, 23, 14, 99, 6, 8, 16};

	@Test
	void t1() {
		long start = System.currentTimeMillis();
		Q1879 q = new Q1879();
		// q.permutation(a2);
		int v = 0;
		v = q.minimumXORSum(a1, a2);
		log.info("dp costs: {} ms. the result is: {}, count: {}",
				System.currentTimeMillis() - start, v, q.ai.get());
	}

	@Test
	void t2() {
		long start = System.currentTimeMillis();
		Q1879 q = new Q1879();
		// q.permutation(a2);
		int v = 0;
		v = q.minimumXORSum1(a1, a2);
		log.info("dp bottom up costs: {} ms. the result is: {}, count: {}",
				System.currentTimeMillis() - start, v, q.ai.get());
	}
}
