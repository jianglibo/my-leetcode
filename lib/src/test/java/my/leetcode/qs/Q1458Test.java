package my.leetcode.qs;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q1458Test {


	@Test
	void t() {
		// [2,1,-2,5]
		// [3,0,-6]
		int nums1[] = {2, 1, -2, 5};
		int nums2[] = {3, 0, -6};
		Q1458 q = new Q1458();
		int v = q.maxDotProduct(nums1, nums2);
		assertThat(v).isEqualTo(10);
	}

	@Test
	void t1() {
		// 5,3
		int[] pa = {5, 2};
		int[] data = new int[pa[1]];
		for (int i = 0; i < pa[1]; i++) {
			data[i] = i;
		}
		for (int i = 0; data[0] < pa[0];) {
			int[] t = Arrays.copyOf(data, data.length);
			log.info("{}", Arrays.toString(t));
			

		}
	}
}
