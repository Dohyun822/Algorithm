import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] stair;
	private static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		stair = new int[N + 1];
		dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = stair[1];
		if (N > 1) {
			dp[2] = stair[1] + stair[2];
		}
		if (N > 2) {
			dp[3] = Math.max(stair[1], stair[2]) + stair[3];
		}

		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
		}
		System.out.println(dp[N]);

	}// end of main
}// end of class