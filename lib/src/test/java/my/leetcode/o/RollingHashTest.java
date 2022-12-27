package my.leetcode.o;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RollingHashTest {
	
	@ParameterizedTest
	@CsvSource({"3,10,63", "10,10,25"})
	void t1(int base, int pow, int result) {
		int c = (int) (Math.pow(base, pow) % 113);

		assertEquals(result, c);
		assertEquals(result, hashPows(base, pow));
	}

	int hashPows(int base, int pow) {
		int n = 1;
		for(int i=0;i<pow;i++) {
			n = (n * base) % 113;
		}
		return n;
	}



}
