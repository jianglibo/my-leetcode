package my.leetcode;

import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.Test;

public class CustomRecursiveActionTest {
	
	@Test
	void t() {
		CustomRecursiveAction cra = new CustomRecursiveAction("hello world");
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		commonPool.submit(cra);
	}
}
