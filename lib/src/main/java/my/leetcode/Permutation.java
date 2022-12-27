package my.leetcode;


import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


public class Permutation {

	public static <T> void printAllRecursiveSetCollection(T[] data, int idx, Set<T> remains) {
		if (idx < data.length) {
			for (T item : remains) {
				data[idx] = item;
				Set<T> s = new HashSet<>(remains);
				s.remove(item);
				printAllRecursiveSetCollection(data, idx + 1, s);
			}
		} else {
			// generated data array.
			// System.out.println(Arrays.toString(data));
		}
	}

	public static <T> void printAllRecursiveSetCollection(int idx, T[] data, Set<T> remains,
			char delimiter, AtomicInteger ai, boolean printIt) {
		if (idx == data.length) {
			if (printIt)
				printArray(data, delimiter);
			ai.incrementAndGet();
		} else {
			for (T item : remains) {
				data[idx] = item;
				remains.remove(item);
				printAllRecursiveSetCollection(idx + 1, data, remains, delimiter,
						ai, printIt);
				remains.add(item);
			}
		}
	}

	public static <T> void printAllRecursiveBit(int idx, T[] data, T[] elements, int mask,
			char delimiter, AtomicInteger ai, boolean printIt) {
		if (idx == data.length) {
			if (printIt)
				printArray(data, delimiter);
			ai.incrementAndGet();
		} else {
			for (int i = 0; i < elements.length; i++) {
				if ((mask & (1 << i)) == 0) {
					data[idx] = elements[i];
					mask |= 1 << i;
					printAllRecursiveBit(idx + 1, data, elements, mask,
							delimiter, ai, printIt);
					mask &= ~(1 << i);
				}

			}
		}
	}

	public static <T> void printAllRecursiveMap(int idx, T[] data, T[] elements,
			Set<Integer> mask, char delimiter, AtomicInteger ai, boolean printIt) {
		if (idx == data.length) {
			if (printIt)
				printArray(data, delimiter);
			ai.incrementAndGet();
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (!mask.contains(elements[i])) {
					data[idx] = elements[i];
					mask.add((Integer) elements[i]);
					printAllRecursiveMap(idx + 1, data, elements, mask,
							delimiter, ai, printIt);
					mask.remove(elements[i]);
				}

			}
		}
	}

	public static <T> void printAllRecursiveBoolean(int idx, T[] data, T[] elements,
			boolean[] mask, char delimiter, AtomicInteger ai, boolean printIt) {
		if (idx == data.length) {
			if (printIt)
				printArray(data, delimiter);
			ai.incrementAndGet();
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (!mask[i]) {
					data[idx] = elements[i];
					mask[i] = true;
					printAllRecursiveBoolean(idx + 1, data, elements, mask,
							delimiter, ai, printIt);
					mask[i] = false;
				}

			}
		}
	}


	public static <T> void printAllRecursiveBitSet(int idx, T[] data, T[] elements, BitSet mask,
			char delimiter, AtomicInteger ai, boolean printIt) {
		if (idx == data.length) {
			if (printIt)
				printArray(data, delimiter);
			ai.incrementAndGet();
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (!mask.get(i)) {
					data[idx] = elements[i];
					mask.set(i);;
					printAllRecursiveBitSet(idx + 1, data, elements, mask,
							delimiter, ai, printIt);
					mask.clear(i);
				}
			}
		}
	}


	public static <T> void printAllRecursive(int n, T[] elements, char delimiter,
			AtomicInteger ai, boolean printIt) {

		if (n == 1) {
			if (printIt)
				printArray(elements, delimiter);
			ai.incrementAndGet();
		} else {
			for (int i = 0; i < n - 1; i++) {
				printAllRecursive(n - 1, elements, delimiter, ai, printIt);
				if (n % 2 == 0) {
					swap(elements, i, n - 1);
				} else {
					swap(elements, 0, n - 1);
				}
			}
			printAllRecursive(n - 1, elements, delimiter, ai, printIt);
		}
	}

	public static <T> void printAllIterative(int n, T[] elements, char delimiter,
			boolean printIt) {

		int[] indexes = new int[n];
		for (int i = 0; i < n; i++) {
			indexes[i] = 0;
		}

		if (printIt)
			printArray(elements, delimiter);

		int i = 0;
		while (i < n) {
			if (indexes[i] < i) {
				swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
				if (printIt)
					printArray(elements, delimiter);
				indexes[i]++;
				i = 0;
			} else {
				indexes[i] = 0;
				i++;
			}
		}
	}

	public static <T extends Comparable<T>> void printAllOrdered1(T[] elements) {
		Arrays.sort(elements);
		boolean hasNext = true;
		while (hasNext) {
			int k = 0, l = 0;
			hasNext = false;
			for (int i = elements.length - 1; i > 0; i--) {
				if (elements[i].compareTo(elements[i - 1]) > 0) {
					k = i - 1;
					hasNext = true;
					break;
				}
			}
			for (int i = elements.length - 1; i > k; i--) {
				if (elements[i].compareTo(elements[k]) > 0) {
					l = i;
					break;
				}
			}
			swap(elements, k, l);
			Collections.reverse(
					Arrays.asList(elements).subList(k + 1, elements.length));
		}
	}

	public static <T extends Comparable<T>> void printAllOrdered(T[] elements, char delimiter,
			AtomicInteger ai, boolean printIt) {

		Arrays.sort(elements);
		boolean hasNext = true;

		while (hasNext) {
			if (printIt)
				printArray(elements, delimiter);
			ai.incrementAndGet();
			int k = 0, l = 0;
			hasNext = false;
			for (int i = elements.length - 1; i > 0; i--) {
				if (elements[i].compareTo(elements[i - 1]) > 0) {
					k = i - 1;
					hasNext = true;
					break;
				}
			}

			for (int i = elements.length - 1; i > k; i--) {
				if (elements[i].compareTo(elements[k]) > 0) {
					l = i;
					break;
				}
			}

			swap(elements, k, l);
			Collections.reverse(
					Arrays.asList(elements).subList(k + 1, elements.length));
		}
	}

	public static <T> void printRandom(T[] elements, char delimiter) {

		Collections.shuffle(Arrays.asList(elements));
		printArray(elements, delimiter);
	}

	public static <T> void recusiveSwap(T[] elements, int idx, char delimiter, AtomicInteger ai,
			boolean printIt) {

		if (idx == elements.length - 1) {
			ai.incrementAndGet();
			if (printIt)
				printArray(elements, delimiter);
		} else {
			for (int i = idx; i < elements.length; i++) {
				swap(elements, idx, i);
				recusiveSwap(elements, idx + 1, delimiter, ai, printIt);
				swap(elements, i, idx);
			}
		}

	}


	private static <T> void swap(T[] elements, int a, int b) {
		T tmp = elements[a];
		elements[a] = elements[b];
		elements[b] = tmp;
	}

	private static <T> void printArray(T[] elements, char delimiter) {

		String delimiterSpace = delimiter + " ";
		for (int i = 0; i < elements.length; i++) {
			System.out.print(elements[i] + delimiterSpace);
		}
		System.out.print('\n');
	}

	// public static void main(String[] argv) {

	// Integer[] elements = {1, 2, 3, 4};

	// System.out.println("Rec:");
	// printAllRecursive(elements, ';');

	// System.out.println("Iter:");
	// printAllIterative(elements.length, elements, ';');

	// System.out.println("Orderes:");
	// printAllOrdered(elements, ';');

	// System.out.println("Random:");
	// printRandom(elements, ';');

	// System.out.println("Random:");
	// printRandom(elements, ';');
	// }
}
