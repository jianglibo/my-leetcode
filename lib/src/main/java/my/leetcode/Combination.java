package my.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Combination {

	// /**
	// *
	// * @param nums
	// * @param idx start position
	// * @param select
	// */
	// void printCombination(int[] nums,int idx, int select, List<List<Integer>> lists) {
	// if (idx > select)return;
	// if (lists.size() < idx + 1) {
	// lists.add(new ArrayList<>());
	// }
	// for(int i=idx; i< nums.length; i++) {
	// lists.add(nums[i]);
	// if (idx == select - 1) {
	// System.out.println(list.toString());
	// list.clear();
	// }
	// printCombination(nums, idx + 1, select, list);
	// }

	// }

	// https://www.baeldung.com/java-combinations-algorithm

	private void combine(List<int[]> combinations, int data[], int start, int end, int index) {
		if (index == data.length) {
			int[] combination = data.clone();
			combinations.add(combination);
		} else if (start <= end) {
			data[index] = start;
			combine(combinations, data, start + 1, end, index + 1);
			combine(combinations, data, start + 1, end, index);
		}
	}

	public void combineSum(List<Integer> combinations, int[] nums, int r, int sum, int start,
			int end, int index) {
		if (index == r) {
			combinations.add(sum);
		} else if (start <= end) {
			combineSum(combinations, nums, r, sum + nums[start], start + 1, end,
					index + 1);
			combineSum(combinations, nums, r, sum, start + 1, end, index);
		}
	}

	private int r;

	private void helperSum1(List<Integer> combinations, AtomicInteger sum, int start, int end,
			int index) {
		if (index == r) {
			combinations.add(sum.get());
			sum.set(0);
		} else if (start <= end) {
			sum.addAndGet(start);
			helperSum1(combinations, sum, start + 1, end, index + 1);
			helperSum1(combinations, sum, start + 1, end, index);
		}
	}


	public List<int[]> generate(int n, int r) {
		List<int[]> combinations = new ArrayList<>();
		combine(combinations, new int[r], 0, n - 1, 0);
		return combinations;
	}

	void printArr(int[] comb) {
		System.out.println(Arrays.toString(comb));
	}

	public void generate2(int n, int r) {
		int[] combination = new int[r];

		for (int i = 0; i < r; i++) {
			combination[i] = i;
		}

		int p = r - 1;

		while (combination[r - 1] < n) {
			// printArr(combination);
			// combinations.add(combination.clone());
			// int v = combination[r - 1];
			// generate next combination in lexicographic order
			// int t = r - 1;
			// // while (t != 0 && combination[t] == n - 1) {
			// while (t != 0 && combination[t] == n - r + t) {
			// t--;
			// }
			int j = 1;
			for (; j < r; j++) {
				if (combination[r - j] != n - j) {
					break;
				}
			}
			int t = r - j;
			// assert t == t1 : "t should always equals to t1";
			combination[t]++;
			for (int i = t + 1; i < r; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}

		// return combinations;
	}


	public void generate1(int n, int r) {
		// List<int[]> combinations = new ArrayList<>();
		int[] combination = new int[r];

		// initialize with lowest lexicographic combination
		for (int i = 0; i < r; i++) {
			combination[i] = i;
		}

		while (combination[r - 1] < n) {
			// printArr(combination);
			// combinations.add(combination.clone());
			// int v = combination[r - 1];
			// generate next combination in lexicographic order
			int t = r - 1;
			// while (t != 0 && combination[t] == n - 1) {
			while (t != 0 && combination[t] == n - r + t) {
				t--;
			}
			combination[t]++;
			for (int i = t + 1; i < r; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}

		// return combinations;
	}

	public int foundResult(int[] nums) {
		int n = nums.length;
		int r = n / 2;
		long sum = 0;
		long res = Integer.MAX_VALUE;

		for (int i : nums) {
			sum += i;
		}

		// List<int[]> combinations = new ArrayList<>();
		int[] combination = new int[r];

		// initialize with lowest lexicographic combination
		for (int i = 0; i < r; i++) {
			combination[i] = i;
		}

		while (combination[r - 1] < n) {
			// combinations.add(combination.clone());
			long subCount = 0;
			for (int i = 0; i < r; i++) {
				subCount += nums[combination[i]];
			}
			long diff = Math.abs(sum - subCount - subCount);
			if (diff < res) {
				res = diff;
			}

			// generate next combination in lexicographic order
			int t = r - 1;
			while (t != 0 && combination[t] == n - r + t) {
				t--;
			}
			combination[t]++;
			for (int i = t + 1; i < r; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}

		return Math.toIntExact(res);
	}



	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		Combination cb = new Combination();
		// int[] nums = {3,9,7,3};
		int[] nums = {2, -1, 0, 4, -2, -9};
		// int[] nums = {7772197, 4460211, -7641449, -8856364, 546755, -3673029, 527497,
		// -9392076, 3130315, -5309187, -4781283, 5919119, 3093450, 1132720,
		// 6380128, -3954678, -1651499, -7944388, -3056827, 1610628, 7711173,
		// 6595873, 302974, 7656726, -2572679, 0, 2121026, -5743797, -8897395,
		// -9699694};
		List<Integer> sumList = new ArrayList<>();


		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		// cb.printCombination(nums, 0, 2, new ArrayList<>());

		int N = nums.length;
		int R = N / 2;

		int[] data = new int[R];

		// cb.combineSum(sumList,data, 0, N, 0);
		System.out.println(sumList.toString());
		sumList.clear();
		cb.r = R;
		cb.helperSum1(sumList, new AtomicInteger(), 0, N, 0);
		System.out.println(sumList.toString());

		List<int[]> combinations = cb.generate(N, 2);

		for (int[] combination : combinations) {
			System.out.println(Arrays.toString(combination));
		}

		// cb.generate1(N, R);
		// List<int[]> selection = cb.generate1(N, R);

		// long res = Integer.MAX_VALUE;

		// for (int[] half : selection) {
		// System.out.print("pair:");
		// int subCount = 0;
		// for (int i = 0; i < half.length; i++) {
		// subCount += nums[half[i]];
		// System.out.print(nums[half[i]] + ",");
		// }
		// long diff = Math.abs(sum - subCount - subCount);
		// if (diff < res) {
		// res = diff;
		// }
		// System.out.println();
		// }
		// System.out.printf("result: %s", res);
		System.out.println();
		System.out.printf("result1: %s", cb.foundResult(nums));
		System.out.println();

		int i = 1 << 2;

		i = 0 >> 0 & 1;

		int[] pos = new int[2];
		int c = pos[1]++;

		int key = 5;
		int key1 = key >> 1;

		System.out.printf("i is: %s", i);
		// System.out.printf("generated %d combinations of %d items from %d ",
		// combinations.size(), R, N);

	}
}
