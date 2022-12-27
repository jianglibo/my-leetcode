package my.leetcode.qs;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Q1942Test {

	@Test
	void t() {
		Q1942 q = new Q1942();

		int[][] times = {{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310},
				{78492, 88209}, {21695, 67063}, {84622, 95452}, {98048, 98856},
				{98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821},
				{48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}};

		// int[][] times = {{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310},
		// {78492, 88209}, {21695, 67063}, {84622, 95452}, {98048, 98856},
		// {98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821},
		// {48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}};
		// Arrays.sort(times, (a, b) -> a[0] - b[0]);
		StringBuilder sb = new StringBuilder();

		for (int[] ii : times)
			sb.append(Arrays.toString(ii) + ", ");
		log.info("{}", sb);
		long start = System.currentTimeMillis();
		int c = -1;
		for(int i=0;i<1000;i++) {
			c = q.smallestChair(Arrays.copyOf(times, times.length), 6);
		}
		log.info("costs: {}ms", System.currentTimeMillis() - start);
		assertThat(c).isEqualTo(2);
	}

	@Test
	void t1() {
		Q1942 q = new Q1942();

		int[][] times = {{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310},
				{78492, 88209}, {21695, 67063}, {84622, 95452}, {98048, 98856},
				{98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821},
				{48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}};

		StringBuilder sb = new StringBuilder();
		for (int[] ii : times)
			sb.append(Arrays.toString(ii) + ", ");
		log.info("{}", sb);
		long start = System.currentTimeMillis();
		int c = -1;
		for(int i=0;i<1000;i++) {
			c = q.smallestChair1(Arrays.copyOf(times, times.length), 6);
		}
		log.info("costs: {}ms", System.currentTimeMillis() - start);
		assertThat(c).isEqualTo(2);
	}
}
