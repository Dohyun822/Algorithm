import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][K + 1];

		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}

		for (int i = 0; i <= N; i++) {
			for (int j = 2; j <= K; j++) {
				for (int k = 0; k <= i; k++) {
					dp[i][j] += dp[i - k][j - 1];
					dp[i][j] %= 1000000000;
				}
			}
		}

		System.out.println(dp[N][K]);

	}
}