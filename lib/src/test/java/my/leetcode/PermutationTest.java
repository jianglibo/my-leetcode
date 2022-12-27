package my.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PermutationTest {
	Integer[] a = {1, 2, 3, 4, 5};
	boolean printIt = true;

	@Test
	void tSetCollection1() {
		long start = System.currentTimeMillis();
		Integer[] data = new Integer[a.length];
		Set<Integer> remains = Arrays.stream(a).collect(Collectors.toSet());
		AtomicInteger ai = new AtomicInteger();
		Permutation.printAllRecursiveSetCollection(data, 0, remains);
		log.info("recursive set costs: {} ms. count: {}",
				System.currentTimeMillis() - start, ai.get());
	}

	@Test
	void tOrdered() {
		long start = System.currentTimeMillis();
		AtomicInteger ai = new AtomicInteger();
		int count = factorial(a);
		Permutation.printAllOrdered(Arrays.copyOf(a, a.length), ',', ai, printIt);
		log.info("all ordered costs: {} ms.", System.currentTimeMillis() - start);
		assertThat(ai.get()).isEqualTo(count);
	}

	@Test
	void tRecursiveSwap() {
		long start = System.currentTimeMillis();
		AtomicInteger ai = new AtomicInteger();
		int count = factorial(a);
		Permutation.printAllRecursive(a.length, Arrays.copyOf(a, a.length), ',', ai,
				printIt);
		log.info("recursive swap costs: {} ms. ai: {}", System.currentTimeMillis() - start,
				ai.get());
		assertThat(ai.get()).isEqualTo(count);
	}

	@Test
	void tSetCollection() {
		long start = System.currentTimeMillis();
		Integer[] data = new Integer[a.length];
		Set<Integer> remains = Arrays.stream(a).collect(Collectors.toSet());
		Set<Integer> threadSafeUniqueNumbers = ConcurrentHashMap.newKeySet();
		threadSafeUniqueNumbers.addAll(remains);
		AtomicInteger ai = new AtomicInteger();
		int count = factorial(a);
		Permutation.printAllRecursiveSetCollection(0, data, threadSafeUniqueNumbers, ',',
				ai, printIt);
		log.info("recursive set costs: {} ms. count: {}",
				System.currentTimeMillis() - start, ai.get());
		assertThat(ai.get()).isEqualTo(count);
	}

	@Test
	void tRecursiveBit() {
		long start = System.currentTimeMillis();
		Integer[] data = new Integer[a.length];
		AtomicInteger ai = new AtomicInteger();
		int count = factorial(a);
		Permutation.printAllRecursiveBit(0, data, a, 0, ',', ai, printIt);
		log.info("recursive bit costs: {} ms. ai: {}", System.currentTimeMillis() - start,
				ai.get());
		assertThat(ai.get()).isEqualTo(count);
	}

	@Test
	void tRecursiveMap() {
		long start = System.currentTimeMillis();
		Integer[] data = new Integer[a.length];
		AtomicInteger ai = new AtomicInteger();
		int count = factorial(a);
		Permutation.printAllRecursiveMap(0, data, a, new HashSet<>(), ',', ai, printIt);
		log.info("recursive bit costs: {} ms. ai: {}", System.currentTimeMillis() - start,
				ai.get());
		assertThat(ai.get()).isEqualTo(count);
	}

	@Test
	void tRecursiveBoolean() {
		long start = System.currentTimeMillis();
		Integer[] data = new Integer[a.length];
		boolean[] mask = new boolean[a.length];
		AtomicInteger ai = new AtomicInteger();
		int count = factorial(a);
		Permutation.printAllRecursiveBoolean(0, data, a, mask, ',', ai, printIt);
		log.info("recursive boolean array costs: {} ms. ai: {}",
				System.currentTimeMillis() - start, ai.get());
		assertThat(ai.get()).isEqualTo(count);
	}

	@Test
	void tAllRecursiveBitSet() {
		long start = System.currentTimeMillis();
		Integer[] data = new Integer[a.length];
		AtomicInteger ai = new AtomicInteger();
		int count = factorial(a);
		Permutation.printAllRecursiveBitSet(0, data, a, new BitSet(), ',', ai, printIt);
		log.info("recursive bitSet costs: {} ms. ai: {}",
				System.currentTimeMillis() - start, ai.get());
		assertThat(ai.get()).isEqualTo(count);
	}

	@Test
	void t7() {
		long start = System.currentTimeMillis();
		Permutations<Integer> perm = new Permutations<Integer>(a);
		int count = 0;
		while (perm.hasNext()) {
			perm.next();
			// System.out.println(Arrays.toString(perm.next()));
			count++;
		}
		// System.out.println("total: " + count);
		// Integer[] data = new Integer[a.length];
		// AtomicInteger ai = new AtomicInteger();
		// int count = factorial(a);
		// Permutation.printAllRecursiveBitSet(0, data, a, new BitSet(), ',', ai, printIt);
		log.info("tail costs: {} ms.", System.currentTimeMillis() - start);
		assertThat(count).isEqualTo(factorial(a));

	}

	@Test
	void tRecursiveSwapBacktrack() {
		long start = System.currentTimeMillis();
		AtomicInteger ai = new AtomicInteger();
		int count = factorial(a);
		Permutation.recusiveSwap(Arrays.copyOf(a, a.length), 0, ',', ai, printIt);
		log.info("recursive backTrack costs: {} ms. ai: {}",
				System.currentTimeMillis() - start, ai.get());
		assertThat(ai.get()).isEqualTo(count);
	}


	@Test
	void t4() {
		log.info("1 << 3: {}", Integer.toBinaryString(1 << 3));
		assertThat(0b100 >> 2 & 1).isEqualTo(1);
		assertThat(0b100 | 1 << 1).isEqualTo(0b110);
		assertThat(0b100 ^ 1 << 2).isEqualTo(0);

		BitSet bs = new BitSet();

		bs.set(0, true);
		assertThat(bs.nextClearBit(0)).isEqualTo(1);
	}

	int factorial(Integer[] a) {
		int v = 1;
		for (int i = 1; i <= a.length; i++) {
			v *= i;
		}
		return v;
	}


}
