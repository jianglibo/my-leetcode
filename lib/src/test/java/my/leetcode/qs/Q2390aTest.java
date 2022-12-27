package my.leetcode.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Q2390aTest {

	@Test
	void tNormal() {
		Q2390a classUnderTest = new Q2390a();
		assertEquals("lecoe", classUnderTest.removeStars("leet**cod*e"));
		assertEquals("coe", classUnderTest.removeStars("le****cod*e"));
		assertEquals("", classUnderTest.removeStars("lecc****"));

	}
}
