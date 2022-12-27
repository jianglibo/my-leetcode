package my.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CombinationTest {

	@Test
	void t() {
		Combination cb = new Combination();
		int[] nums = {2, -1, 0, 4, -2, -9};
		List<int[]> combinations = cb.generate(nums.length, 2);
		combinations.forEach(ai -> log.info("{}", Arrays.toString(ai)));
		assertThat(combinations).hasSize(15);
	}

	@Test
	void tGenerate1() {
		long start = System.currentTimeMillis();
		Combination cb = new Combination();
		cb.generate1(60, 6);
		log.info("ms: {}", System.currentTimeMillis() - start);

	}
	@Test
	void tGenerate2() {
		long start = System.currentTimeMillis();
		Combination cb = new Combination();
		cb.generate2(60, 6);
		log.info("ms: {}", System.currentTimeMillis() - start);

	}

	@Test
	void tCombineSum() {
		Combination cb = new Combination();
		int[] nums = {2, -1, 0, 4, -2, -9};
		List<Integer> combinations = new ArrayList<>();
		cb.combineSum(combinations, nums, 2, 0, 0, nums.length - 1, 0);
		Integer[] values = combinations.toArray(Integer[]::new);
		log.info("{}", Arrays.toString(values));
		// [1, 2, 3, 4, 5, 3, 4, 5, 6, 5, 6, 7, 7, 8, 9]
		assertThat(combinations).hasSize(15);

		
		PriorityQueue<Integer> leftq = new PriorityQueue<>(Arrays.stream(nums).boxed().toList());
		assertThat(leftq.stream().collect(Collectors.summingLong(i -> i))).isEqualTo(-6);

		// int sum =0;
		// for(int i=0;leftq.iterator().hasNext();i++) {
		// 	sum += leftq.iterator().next();
		// }
		Map<String, Integer> imap = new HashMap<>();
		imap.compute("imap", (String k, Integer v) -> {
			return null;
		});
		assertThat(IntStream.range(1, 5).toArray()).isEqualTo(new int[]{1,2,3,4});

		Queue<Integer> iq = new LinkedList<>();
		iq.add(1);
		iq.add(2);

		assertThat(iq.poll()).isEqualTo(1);
	// combinations.set
		// Collections.sort(null);
		Integer i1 = 5, i2 = 5;
		Long l1 = 5L;
		assertThat(i1 == i2).isTrue();
		

	}
}
