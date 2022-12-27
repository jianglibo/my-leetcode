package my.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BitMaskTest {


	@Test
	void t() {

		for (int i = 0; i < 1 << 6; i++) {
			Integer.lowestOneBit(i);
			if (Integer.bitCount(i) == 3) {
				log.info("value: {}", i);
				log.info("binary string: {}", Integer.toBinaryString(i));
			}
		}

	}

	@Test
	void tBits() {
		// unset
		int n = 6;
		int j = (1 << n) - 1;
		log.info("(1 << n) - 1: {}", Integer.toBinaryString(j));
		log.info("j |= 1 << 2: {}", Integer.toBinaryString(j |= 1 << 2));
		log.info("j &= ~(1 << 2): {}", Integer.toBinaryString(j &= ~(1 << 2)));
		log.info("j ^= 1 << 3: {}", Integer.toBinaryString(j ^= 1 << 3));
		log.info("j ^= 1 << 3: {}", Integer.toBinaryString(j ^= 1 << 3));
		int j1 = ~(1 << n);
		log.info("~(1 << n): {}", Integer.toBinaryString(j1));
		for (int i = 0; i < n; i++) {
			// int k = j 
			if (Integer.bitCount(i) == 3) {
				log.info("value: {}", i);
				log.info("binary string: {}", Integer.toBinaryString(i));
			}
		}

	}

	@Test
	void t1() {
		int i = Integer.lowestOneBit(10);
		assertEquals(2, i);;

		i = 10 ^ 2;
		assertEquals(8, i);

		for (int j = 0; j < 1 << 8; j++) {
			int b = 10 & (1 << j);
			if (b > 0) {
				log.info("bits: {}", b);
			}
		}

		int[] nums = {1,2,3};
		int c = Arrays.binarySearch(nums, 2);
		assertThat(c).isEqualTo(1);

	}
}
