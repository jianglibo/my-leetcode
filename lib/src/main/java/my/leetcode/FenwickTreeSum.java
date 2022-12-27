package my.leetcode;

import java.util.Arrays;

public class FenwickTreeSum {

	final private int[] tree;

	/**
	 * 
	 * @param ar - data starts at index 1, ar[0] is ignored
	 */
	public FenwickTreeSum(int[] ar) {
		this.tree = this.make(ar);
	}

	/**
	 * Assumes data starts at index 1. Value at index zero is ignored.
	 * 
	 * @param ar
	 * @return
	 */
	int[] make(int[] ar) {
		int[] tree = Arrays.copyOf(ar, ar.length);

		for (int i = 1; i < tree.length; i++) {
			int p = i + (i & -i); // index to parent range
			if (p < tree.length) {
				tree[p] = tree[p] + tree[i];
			}
		}

		return tree;
	}


	/**
	 * Returns the sum from index 1 to i (inclusive)
	 * 
	 * @param i
	 */
	public int sum(int i) {
		int sum = 0;
		while (i > 0) {
			sum += tree[i];
			i -= i & -i; // zeroes the least significant bit of value 1
		}
		return sum;
	}

	/**
	 * returns the sum from i to j (inclusive)
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public int sum(int i, int j) {
		return sum(j) - sum(i - 1);
	}

	/**
	 * just the value from the "original array" at index i
	 * 
	 * @param i
	 * @return
	 */
	public int valueAt(int i) {
		return sum(i) - sum(i - 1);
	}

	/**
	 * Adds k to element at index i, propagating the change to the right end of the tree so that
	 * range operations still work
	 * 
	 * @param i
	 * @param k
	 */
	private void add(int i, int k) {
		while (i < tree.length) {
			tree[i] += k;
			i += i & -i; // take the least significant set bit and add to i
		}
	}

	/**
	 * updates the
	 * 
	 * @param i
	 * @param value
	 */
	public void update(int i, int value) {
		int orig = valueAt(i);
		add(i, value - orig);
	}

	public int possibles(FenwickTreeSum ft, int len) {
		int sum = ft.sum(1, len);

		int res = 0;
		for (int i = 1; i < len; i++) {
			int left = ft.sum(1, i);
			int right = sum - left;
			if (left == right) {
				++res;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {27335,-27335,0,0,0,0,97328,-97328,0,79944,-79944,0,0,0,0,-73546,73546,0,0,0,0,-62146,62146,55310,-55310,0,0,0,0,-17202,17202,0,0,0,18526,-18526,41634,-41634,0,46865,-46865,0,40195,-40195,0,79602,-79602,0,0,0,0,73130,-73130,0,82429,-82429,0,92028,-92028,0,0,0,0,27539,-27539,0,136,-136,0,0,54670,-54670,0,0,-95468,95468,0,0,0,0,48155,-48155,0};
		int k = 73874;
		int len = nums.length;
		int ar[] = new int[len + 1];
		ar[0] = 0;
		for (int i = 0; i < len; i++) {
			ar[i + 1] = nums[i];
		}

		FenwickTreeSum ft = new FenwickTreeSum(ar);
		int res = ft.possibles(ft, len);

		int[] counts = new int[len];

		for (int i = 0; i < len; i++) {
			int tmp = ft.valueAt(i + 1);
			ft.update(i + 1, k);
			counts[i] = ft.possibles(ft, len);
			ft.update(i + 1, tmp);
		}

		for (int i = 0; i < nums.length; i++) {
			res = Math.max(res, counts[i]);
		}
		System.out.println(res);
		// return res;



		// data starts at index 1. ar[0] is ignored
		// int ar[] = new int[]{0, 5, 2, 9, -3, 5, 20, 10, -7, 2, 3, -4, 0, -2, 15, 5};
		// int ar[] = new int[]{-1,-1,2,3};
		// FenwickTreeSum ft = new FenwickTreeSum(ar);
		// System.out.println("value at 3 = " + ft.valueAt(3));
		// System.out.println("value at 0 = " + ft.valueAt(0));
		// System.out.println("value at 1 = " + ft.valueAt(1));
		// System.out.println("sum(0, 3) = " + ft.sum(0, 3));
		// System.out.println("sum(0, 3) = " + ft.sum(0, ar.length - 1));


	}
}
