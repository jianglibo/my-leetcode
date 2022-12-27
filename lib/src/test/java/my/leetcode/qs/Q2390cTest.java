package my.leetcode.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Q2390cTest {

	@Test
	void tNormal() {
		Q2390c classUnderTest = new Q2390c();
		assertEquals("lecoe", classUnderTest.removeStars("leet**cod*e"));
		assertEquals("coe", classUnderTest.removeStars("le****cod*e"));

	}
}
