import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[][] arr;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			arr[i][0] = T;
			arr[i][1] = P;
		}

		dp = new int[N + 2];
		Arrays.fill(dp, 0);

		for (int i = 1; i <= N; i++) {
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
			if (i + arr[i][0] <= N + 1) {
				dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
			}
		}

		System.out.println(dp[N + 1]);
	}
}
