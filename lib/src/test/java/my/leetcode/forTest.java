package my.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class forTest {
	

	@Test
	void t1() {
		int i;
		
		i=0;
		for(;i<10;++i) {
			System.out.println(i);
			;
		}
		assertThat(i).isEqualTo(10);

		i=0;
		for(;i<10;i++) {
			System.out.println(i);
			;
		}
		assertThat(i).isEqualTo(10);
	}

	@Test
	void t2() {
		int[] nums = {-5, -3, 3, 6};
		int j = Arrays.binarySearch(nums, 0);
		assertThat(j).isEqualTo(-3);
		int[] nums1 = {-5, -3, 0, 6};
		j = Arrays.binarySearch(nums1, 0);
		assertThat(j).isEqualTo(2);


		int[] nums2 = {-5, -3,0, 0, 0, 0, 6};
		j = Arrays.binarySearch(nums2, 0);
		// assertThat(j).isEqualTo(2);

		List<Integer> l = new ArrayList<>();
		l.toArray(Integer[]::new);
		
		// assertThat(Arrays.toString(nums2)).isEqualTo("");
		long v = (long) 1e5;
		assertThat(v).isEqualTo(100000L);
	}

	@Test
	void t3() {
		char[] a = new char[]{'{', '[', '('} ;
		assertThat(Arrays.binarySearch(a, '{')).isNotEqualTo(-1);
		assertThat(Arrays.binarySearch(a, '[')).isNotEqualTo(-1);
		assertThat(Arrays.binarySearch(a, '(')).isEqualTo(-1);
		Arrays.sort(a);
		assertThat(Arrays.binarySearch(a, '{')).isNotEqualTo(-1);
		assertThat(Arrays.binarySearch(a, '[')).isNotEqualTo(-1);
		assertThat(Arrays.binarySearch(a, '(')).isNotEqualTo(-1);
		char[] a1 = new char[]{'}', ']', ')'} ;
		Arrays.sort(a1);
		log.info("a {}", Arrays.toString(a));
		log.info("a1 {}", Arrays.toString(a1));

		log.info("...".substring(0, 1));
		log.info("...".substring(2));

		int p1 =2;
		int p2 = p1 + 1;
		log.info("....".substring(0, p1) + "--" + "....".substring(p2 + 1));

	}

	@Test
	void f() {
		String s = "..-...";
		for(int p1=0; p1 < s.length() - 1;p1++) {
			char c = s.charAt(p1), c1 = s.charAt(p1 + 1);
			if (c == '.' && c1 == '.') {
				log.info(s.substring(0, p1) + "--" + s.substring(p1 + 2));
			}
		}
			int x = 5^5;
			assertThat(x).isEqualTo(0);
			assertThat((long)Math.pow(2, 14)).isEqualTo(16384L);
			assertThat(0b11111111111111).isEqualTo(16383L);
			log.info(Integer.toBinaryString(16384));
			log.info(Integer.toBinaryString(Integer.MAX_VALUE)); //1111111111111111111111111111111
	}
}
