package my.leetcode.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import my.leetcode.TreeNode;

public class Q606Test {
	@Test
	void t1() {
		Q606 classUnderTest = new Q606();
		assertEquals(classUnderTest.tree2str(TreeNode.newTree(1)), "1");
	}

	@Test
	void t4() {
		Q606 classUnderTest = new Q606();
		assertEquals(classUnderTest.tree2str(TreeNode.newTree(1, 2, 3, 4)), "1(2(4))(3)");
	}

}
