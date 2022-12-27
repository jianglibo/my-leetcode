package my.leetcode.qs;

public class Q476 {
	public int findComplement(int num) {
		return (Integer.highestOneBit(num) << 1) - num - 1;
    }
}
