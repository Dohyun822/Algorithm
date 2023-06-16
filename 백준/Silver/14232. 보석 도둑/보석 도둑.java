import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Long> stones = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		long k = Long.parseLong(br.readLine());

		find(k);

		sb.append(stones.size()).append("\n");
		for (Long stone : stones)
			sb.append(stone).append(" ");
		System.out.println(sb.toString());

	} // end of main

	static void find(long k) {
		for (long i = 2; i * i <= k; i++) {
			while (k % i == 0) {
				stones.add(i);
				k /= i;
			}
		}
		if (k > 1)
			stones.add(k);
	}
}// end of class