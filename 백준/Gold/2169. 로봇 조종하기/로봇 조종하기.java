import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[][] arr;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[1][1] = arr[1][1];

		for (int j = 2; j <= M; j++) {
			dp[1][j] = dp[1][j - 1] + arr[1][j];
		}

		for (int i = 2; i <= N; i++) {
			dp[i][1] = dp[i - 1][1] + arr[i][1];
		}

		for (int i = 2; i <= N; i++) {
			int[] lr = new int[M + 1];
			int[] rl = new int[M + 1];

			lr[1] = dp[i - 1][1] + arr[i][1];
			for (int j = 2; j <= M; j++) {
				lr[j] = Math.max(lr[j - 1], dp[i - 1][j]) + arr[i][j];
			}

			rl[M] = dp[i - 1][M] + arr[i][M];
			for (int j = M - 1; j >= 1; j--) {
				rl[j] = Math.max(rl[j + 1], dp[i - 1][j]) + arr[i][j];
			}

			for (int j = 1; j <= M; j++) {
				dp[i][j] = Math.max(lr[j], rl[j]);
			}
		}

		System.out.println(dp[N][M]);
	}
}