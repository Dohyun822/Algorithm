import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static int[] prefix_sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		prefix_sum = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		int answer = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			prefix_sum[i] = prefix_sum[i - 1] + Integer.parseInt(st.nextToken());
			if (i >= K) {
				answer = answer > prefix_sum[i] - prefix_sum[i - K] ? answer : prefix_sum[i] - prefix_sum[i - K];
			}
		}

		System.out.println(answer);

	}
}