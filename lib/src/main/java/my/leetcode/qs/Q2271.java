package my.leetcode.qs;

import java.util.Arrays;
import java.util.Comparator;

public class Q2271 {
	int getTileNumber(int[] tiles) {
		return tiles[1] - tiles[0] + 1;
	}

	int getGap(int[] prev, int[] next) {
		return next[0] - prev[1] - 1;
	}

	public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
		Arrays.sort(tiles, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});

		int totalTiles = 0;
		for (int[] tile : tiles) {
			totalTiles += getTileNumber(tile);
		}

		for (int clen = carpetLen > totalTiles ? totalTiles : carpetLen; clen > 1; clen--) {
			for (int i = 0; i < tiles.length; i++) {
				int[] currentStartTile = tiles[i];
				int[] preTile = currentStartTile;
				int currentTileLength = getTileNumber(currentStartTile);
				if (currentTileLength >= clen) {
					return clen;
				}
				int gap = 0;
				for (int j = i + 1; j < tiles.length; j++) {
					int[] nextTile = tiles[j];
					gap += getGap(preTile, nextTile);
					currentTileLength = nextTile[1] - currentStartTile[0] + 1;
					int carpetEndPositon = currentStartTile[0] + carpetLen - 1;
					int partNextTile;

					if (carpetEndPositon < nextTile[0]) {
						partNextTile = getTileNumber(nextTile);
					} else if (carpetEndPositon >= nextTile[1]) {
						partNextTile = 0;
					} else {
						partNextTile = nextTile[1] - carpetEndPositon;
					}
					int coveredTiles = currentTileLength - partNextTile - gap;
					if (coveredTiles >= clen) {
						return clen;
					}
					if (currentTileLength >= carpetLen) {
						break;
					}
					preTile = nextTile;
				}
			}
		}
		return 1;
	}
}
