package my.leetcode.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Q476Test {
	
	@Test
	void t1() {
		assertEquals(2, Integer.highestOneBit(2));
		assertEquals(4, Integer.highestOneBit(4));
		assertEquals(4, Integer.highestOneBit(5));
		assertEquals(4, Integer.highestOneBit(6));
		assertEquals(4, Integer.highestOneBit(7));
		assertEquals(8, Integer.highestOneBit(8));
		assertEquals(15, (Integer.highestOneBit(8) << 1) - 1); // 10000, 01111
	}
}
