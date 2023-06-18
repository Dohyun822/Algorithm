import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	private static int N;
	private static long K;
	private static long[] arr;
	private static long[] prefix_sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());

		arr = new long[N + 1];
		prefix_sum = new long[N + 1];

		st = new StringTokenizer(br.readLine(), " ");

		long answer = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			prefix_sum[i] = prefix_sum[i - 1] + arr[i]; // 누적합
//			if (prefix_sum[i] == K) {
//				answer++;
//			}

		}

		HashMap<Long, Long> hashmap = new HashMap<>();
		for (int i = 0; i <= N; i++) {
			if (hashmap.containsKey(prefix_sum[i] - K)) {
				answer += hashmap.get(prefix_sum[i] - K);
			}
			hashmap.put(prefix_sum[i], hashmap.getOrDefault(prefix_sum[i], 0L) + 1);

		}

		System.out.println(answer);

	}
}