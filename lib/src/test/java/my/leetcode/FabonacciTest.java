package my.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FabonacciTest {

	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> res1 = new HashMap<>();

		for (String s : strings) {
			res1.merge(cal(s), new ArrayList<>(Arrays.asList(s)), (old, one) -> {
				old.add(s);
				return old;
			});
		}
		return new ArrayList<>(res1.values());
	}

	String cal(String s) {
		if (s.length() == 1)
			return "[]";
		int[] v = new int[s.length() - 1];
		for (int i = 1; i < s.length(); i++) {
			int diff = s.charAt(i) - s.charAt(i - 1);
			v[i - 1] = diff > 0 ? diff : 26 + diff;
		}
		return Arrays.toString(v);
	}

	@Test
	void tRecurssion() {
		Fabonacci fb = new Fabonacci();
		List<Integer> values = new ArrayList<>();
		int r = fb.recurssion(values, 19);
		assertThat(r).isEqualTo(4181);

		values = new ArrayList<>();
		r = fb.recurssion(values, 6);
		assertThat(r).isEqualTo(8);
		// 0 1 1 2 3 5 8
		log.info("{}", Arrays.toString(values.toArray(Integer[]::new)));
		// assertThat(values).hasSize(5);
	}

	int f1() {
		return 1;
	}

	int f2() {
		return 2;
	}

	@Test
	void tDp() {
		Fabonacci fb = new Fabonacci();
		int[] res = fb.dp(15);
		log.info("{}", Arrays.toString(res));

		if (f1() == f2()) {
			log.info("yes");
		}
		if (f2() == f1()) {
			log.info("yes");
		}

		Set<Integer> seen = new HashSet<>();
		seen.add(1);

		int c = 'a' - 'b';
		assertThat(c).isEqualTo(-1);
		int[] a1 = {1, 2, 3};
		int[] a2 = {1, 2, 3};
		assertThat(Arrays.equals(a1, a2)).isTrue();
		int[] a3 = {1, 2, 4};
		assertThat(Arrays.equals(a1, a3)).isFalse();
		String[] ss = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		Arrays.sort(ss);
		log.info("{}", Arrays.toString(ss));
		Arrays.sort(ss, (s1, s2) -> s1.length() - s2.length());
		log.info("{}", Arrays.toString(ss));

		Map<String, List<String>> res1 = new HashMap<>();

		for (String s : ss) {
			res1.merge(cal(s), new ArrayList<>(Arrays.asList(s)), (old, one) -> {
				old.add(s);
				return old;
			});
		}
		List<List<String>> lls = new ArrayList<>(res1.values());
		res1.forEach((k, v) -> {
			log.info("key: {}", k);
			log.info("val: {}", Arrays.toString(v.toArray(String[]::new)));
		});
		assertThat(res1).hasSize(4);

		int[][] aa = new int[2][3];
		int[] a = {1,2};
		Arrays.binarySearch(aa, a, (x, y) -> x[0] - y[0]);
		

	}

}
