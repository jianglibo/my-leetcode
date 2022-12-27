package my.leetcode.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import my.leetcode.TreeNode;

public class Q606aTest {
	@Test
	void t1() {
		Q606a classUnderTest = new Q606a();
		assertEquals(classUnderTest.tree2str(TreeNode.newTree(1)), "1");
	}

	@Test
	void t4() {
		Q606a classUnderTest = new Q606a();
		assertEquals(classUnderTest.tree2str(TreeNode.newTree(1, 2, 3, 4)), "1(2(4))(3)");
	}

}
