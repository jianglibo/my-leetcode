package my.leetcode.qs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Partition {


	public boolean canPartitionKSubsets(int[] arr, int k) {
		int totalArraySum = 0;
		int n = arr.length;

		for (int i = 0; i < n; ++i) {
			totalArraySum += arr[i];
		}

		// If total sum not divisible by k, we can't make subsets.
		if (totalArraySum % k != 0) {
			return false;
		}

		int targetSum = totalArraySum / k;

		int[] subsetSum = new int[(1 << n)];
		for (int i = 0; i < (1 << n); ++i) {
			subsetSum[i] = -1;
		}
		// Initially only one state is valid, i.e don't pick anything.
		subsetSum[0] = 0;

		for (int mask = 0; mask < (1 << n); mask++) {
			// If the current state has not been reached earlier.
			if (subsetSum[mask] == -1) {
				continue;
			}

			for (int i = 0; i < n; i++) {
				// If the number arr[i] was not picked earlier, and arr[i] +
				// subsetSum[mask]
				// is not greater than the targetSum then add arr[i] to the subset
				// sum at subsetSum[mask] and store the result at subsetSum[mask |
				// (1 << i)].
				if ((mask & (1 << i)) == 0
						&& subsetSum[mask] + arr[i] <= targetSum) {
					subsetSum[mask | (1 << i)] =
							(subsetSum[mask] + arr[i]) % targetSum;
				}
			}

			if (subsetSum[(1 << n) - 1] == 0) {
				return true;
			}
		}

		return subsetSum[(1 << n) - 1] == 0;
	}


	// every slot has n possibles,
	// when the function will finally return? i == ar.length
	// every recursion receive different i value;
	boolean part(int ar[], int i, int[] target, List<List<Integer>> p) {
		for (int k = 0; k < target.length && i < ar.length; k++) {
			if (target[k] >= ar[i]) {
				target[k] -= ar[i];

				if (part(ar, i + 1, target, p)) { // always try from the first
									// bucket.
					p.get(k).add(ar[i]);
					break;
				} else { // if failed, do backtrack. try to put into another bucket.
						// k + 1.
					target[k] += ar[i];
				}
			}
		}
		return IntStream.of(target).sum() == 0;
	}


	public boolean partition(List<Integer> ar, int[] target, int trgIdx, List<List<Integer>> p,
			Map<String, Boolean> mem) {
		Collections.sort(ar);
		String key = ar.toString() + "|" + Arrays.toString(target);
		Boolean possible = mem.get(key);
		if (possible != null) {
			return possible;
		}

		/*
		 * Each of K subsets need to fill up. Equivalently, each of the target[k] need to be
		 * reduced to zero
		 */
		for (int k = trgIdx; k < target.length; k++) {
			/*
			 * Any of the values in ar[] could be used to reduce target[k], so we need
			 * to try each one. Iterate backwards so that we can put back values easily.
			 */
			for (int idx = ar.size() - 1; idx >= 0 && target[k] > 0; idx--) {

				if (target[k] >= ar.get(idx)) { // make sure not to go negative on
								// target
					Integer value = ar.remove(idx);
					target[k] -= value;

					if (partition(ar, target, k, p, mem)) {
						// keep the removed value in this sub-list
						p.get(k).add(value);

					} else {
						// try removing some other value, but first put
						// back. It's OK to add to the end since idx is
						// decreasing
						ar.add(value);
						target[k] += value;
					}
				}
			}

			if (target[k] != 0) {
				mem.put(key, false);
				return false;
			}
		}

		mem.put(key, ar.isEmpty());

		return ar.isEmpty();
	}
}
