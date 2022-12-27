package my.leetcode.qs;

import java.util.Arrays;
import java.util.Comparator;

public class Q2271a {
	public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
		Arrays.sort(tiles, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});

		int res = 0;
		int cover = 0;

		for (int i = 0, j = 0; res < carpetLen && j < tiles.length;) {
			if (tiles[i][0] + carpetLen > tiles[j][1]) {
				cover += tiles[j][1] - tiles[j][0] + 1;
				res = Math.max(res, cover);
				++j;
			} else {
				int partial = Math.max(0,   tiles[i][0] + carpetLen - tiles[j][0]);
				res = Math.max(res, cover + partial);
				cover -= (tiles[i][1] - tiles[i][0] + 1);
				++i;
			}
		}
		return res;
	}
}