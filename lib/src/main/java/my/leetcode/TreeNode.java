package my.leetcode;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode newTree(Integer... vars) {
		return newTree(0, vars);
	}

	private static TreeNode newTree(int index, Integer... vars) {
		if (index >= vars.length || vars[index] == null)
			return null;

		TreeNode node = new TreeNode(vars[index]);
		node.left = newTree(2 * index + 1, vars);
		node.right = newTree(2 * index + 2, vars);

		return node;
	}

}
