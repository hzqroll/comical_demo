import java.util.Random;

/**
 * Date: 2017/9/26
 *
 * @author zongqiang.hao
 */
public class TestTime {
	public static void main(String args[]) {
		testRandom();
		testLest();
	}

	private static void testRandom() {
		long currentTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 10000000; i++) {
			long random = new Random().nextInt(100);
			if (random > 50) {
				count++;
			}
		}
		System.out.println("random time: " + String.valueOf(System.currentTimeMillis() - currentTime) + "count: " + count);
	}

	private static void testLest() {
		long currentTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 10000000; i++) {
			if ((System.currentTimeMillis() % 100) > 50) {
				count++;
			}
		}
		System.out.println("lest time: " + String.valueOf(System.currentTimeMillis() - currentTime) + "count: " + count);
	}
}
