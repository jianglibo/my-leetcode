package my.leetcode.qs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1942 {

	int imComming(int[][] times, boolean[] lefted, int commingIdx, int end) {
		int firstMet = -1;
		for (int i = 0; i < commingIdx; i++) {
			if (lefted[i] || times[i][1] <= times[commingIdx][0]) {
				if (firstMet == -1) {
					firstMet = i;
				}
				lefted[i] = true;
			}
		}

		if (firstMet != -1) {
			times[firstMet] = times[commingIdx];
			lefted[firstMet] = false;
			lefted[commingIdx] = true;
		}
		return firstMet;
	}

	public int smallestChair1(int[][] times, int targetFriend) {
		int n = times.length;
		PriorityQueue<Integer> chairs = new PriorityQueue<>();
		PriorityQueue<int[]> leaveTimes = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		int[][] sortedTimes = new int[n][3];
		for (int i = 0; i < n; i++) {
			chairs.offer(i);
			sortedTimes[i][0] = times[i][0];
			sortedTimes[i][1] = times[i][1];
			sortedTimes[i][2] = i;
		}
		Arrays.sort(sortedTimes, (a, b) -> a[0] - b[0]);

		for (int i = 0; i < n; i++) {
			int arrival = sortedTimes[i][0], leaving = sortedTimes[i][1],
					friendId = sortedTimes[i][2];
			while (!leaveTimes.isEmpty() && arrival >= leaveTimes.peek()[0])
				chairs.offer(leaveTimes.poll()[1]);
			if (friendId == targetFriend)
				return chairs.poll();
			int chairId = chairs.poll();
			leaveTimes.offer(new int[] {leaving, chairId});
		}
		return -1;
	}


	public int smallestChair(int[][] times, int targetFriend) {
		int[] t = times[targetFriend];
		Arrays.sort(times, (a, b) -> a[0] - b[0]);
		int p = Arrays.binarySearch(times, t, (a, b) -> a[0] - b[0]);

		boolean[] lefted = new boolean[p + 1];
		// when I'm comming is there any empty chairs?
		int v = -1;
		for (int i = 1; i <= p; i++) {
			v = imComming(times, lefted, i, p);
		}
		return v == -1 ? p : v;
	}
}
