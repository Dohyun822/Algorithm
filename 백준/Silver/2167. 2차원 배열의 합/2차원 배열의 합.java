import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[][] arr;
	private static int K;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		dp = new int[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + arr[i][j];
			}
		}

		K = Integer.parseInt(br.readLine());

		for (int a = 0; a < K; a++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int result = dp[x][y] - dp[x][j - 1] - dp[i - 1][y] + dp[i - 1][j - 1];
			System.out.println(result);
		}
	}
}