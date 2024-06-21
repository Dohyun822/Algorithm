import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());

		List<Long> stones = factorize(k);

		// 결과 출력
		System.out.println(stones.size());
		for (long stone : stones) {
			System.out.print(stone + " ");
		}
	}

	private static List<Long> factorize(long n) {
		List<Long> stones = new ArrayList<>();
		for (long i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				stones.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			stones.add(n);
		}
		Collections.sort(stones);
		return stones;
	}
}
