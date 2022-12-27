package my.leetcode.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Q1234Test {
	@Test
	void t1() {
		Q1234 classUnderTest = new Q1234();
		assertEquals(3, classUnderTest.balancedString("WQWRQQQW"));
		assertEquals(1, classUnderTest.balancedString("QQWE"));
		assertEquals(0, classUnderTest.balancedString("QRWE"));


		assertEquals(4, classUnderTest.balancedString("WWEQERQWQWWRWWERQWEQ"));


	}


}
