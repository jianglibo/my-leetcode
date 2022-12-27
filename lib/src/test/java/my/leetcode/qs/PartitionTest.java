package my.leetcode.qs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PartitionTest {

	@Test
	void t1() {
		Partition p = new Partition();
		// int ar[] = {4,2,3,6,3,1,5};
		int ar[] = {4, 2, 3, 6, 3, 1};
		int target[] = {8, 8, 8};
		List<List<Integer>> lists = Arrays.asList(new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>());

		p.part(ar, 0, target, lists);
		System.out.println(lists);
	}

	@Test
	void t2() {
		Partition p = new Partition();
		int ar[] = {1, 2, 1, 1, 1};
		int target[] = {2, 2, 2};
		List<List<Integer>> lists = Arrays.asList(new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>());

		p.part(ar, 0, target, lists);
		System.out.println(lists);
	}

	@Test
	void t3() {
		Partition p = new Partition();
		int[] ints = {3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037,
				2646, 3871, 269};
		TestData td = TestData.create(ints, 5);
		long startTime = System.nanoTime();
		p.part(td.nums, 0, td.targets, td.lists);
		long costs = System.nanoTime() - startTime;
		System.out.println(costs);
	}

	@Test
	void t4() {
		Partition p = new Partition();
		int[] ints = {1, 1, 1, 1};
		List<Integer> ar = new ArrayList<>();
		for (int i : ints) {
			ar.add(i);
		}
		int targets[] = {2, 2};
		List<List<Integer>> lists = Arrays.asList(new ArrayList<>(), new ArrayList<>());
		boolean b = p.partition(ar, targets, 0, lists, new HashMap<>());
		assertThat(b).isTrue();
		System.out.println(lists);
	}

	@Test
	void t5() {
		Partition p = new Partition();
		int[] ints = {3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037,
				2646, 3871, 269};
		TestData td = TestData.create(ints, 5);
		long startTime = System.nanoTime();
		boolean b = p.partition(td.ar, td.targets, 0, td.lists, new HashMap<>());
		long costs = System.nanoTime() - startTime;
		System.out.println(costs);
		assertThat(b).isTrue();
	}

	@Test
	void t6() {
		Partition p = new Partition();
		int[] ints = {3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037,
				2646, 3871, 269};
		long startTime = System.nanoTime();
		boolean b = p.canPartitionKSubsets(ints, 5);
		long costs = System.nanoTime() - startTime;
		System.out.println(costs);
		assertTrue(b);
	}

	static class TestData {
		int[] nums;
		List<Integer> ar;
		int[] targets;
		List<List<Integer>> lists;
		int k;

		static TestData create(int[] ints, int k) {
			TestData td = new TestData();
			td.nums = ints;
			td.k = k;
			td.ar = new ArrayList<>();
			int totalArraySum = 0;
			for (int i : ints) {
				td.ar.add(i);
				totalArraySum += i;
			}

			if (totalArraySum % k != 0) {
				assertTrue(false);
			}

			td.targets = new int[k];
			int targetSum = totalArraySum / k;
			Arrays.fill(td.targets, targetSum);
			td.lists = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				td.lists.add(new ArrayList<>());
			}
			return td;
		}
	}
}
