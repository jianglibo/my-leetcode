package my.leetcode.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Q2271aTest {
	@Test
	void t0() {
		Q2271a classUnderTest = new Q2271a();
		int[][] tiles = {{1, 1}, {10, 18}};
		int v = classUnderTest.maximumWhiteTiles(tiles, 11);
		assertEquals(9, v);
	}
	@Test
	void t1() {
		Q2271a classUnderTest = new Q2271a();
		int[][] tiles = {{1, 5}, {10, 11}, {12, 18}, {20, 25}, {30, 32}};
		int v = classUnderTest.maximumWhiteTiles(tiles, 10);
		assertEquals(9, v);
	}

	@Test
	void t2() {
		Q2271a classUnderTest = new Q2271a();
		int[][] tiles = {{10, 11}, {1, 1}};
		int v = classUnderTest.maximumWhiteTiles(tiles, 2);
		assertEquals(2, v);
	}

	@Test
	void t3() {
		Q2271a classUnderTest = new Q2271a();
		int[][] tiles = {{8051, 8057}, {8074, 8089}, {7994, 7995}, {7969, 7987},
				{8013, 8020}, {8123, 8139}, {7930, 7950}, {8096, 8104},
				{7917, 7925}, {8027, 8035}, {8003, 8011}}; //7,16,2,19,8,17,21,9,9,9,9
		int v = classUnderTest.maximumWhiteTiles(tiles, 9854);
		assertEquals(126, v);
	}

}
