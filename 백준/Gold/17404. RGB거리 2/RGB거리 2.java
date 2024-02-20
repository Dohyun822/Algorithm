import java.io.*;
import java.util.*;

public class Main {
	static int[][] cost;
	static int[][] dp;
	static final int INF = 1000 * 1000 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(input[j]);
			}
		}

		int answer = INF;
		for (int i = 0; i < 3; i++) {
			answer = Math.min(answer, solve(N, i));
		}

		System.out.println(answer);
	}

	static int solve(int N, int firstColor) {
		for (int i = 0; i < 3; i++) {
			if (i == firstColor) {
				dp[0][i] = cost[0][i];
			} else {
				dp[0][i] = INF;
			}
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
		}

		int minCost = INF;
		for (int i = 0; i < 3; i++) {
			if (i != firstColor) {
				minCost = Math.min(minCost, dp[N - 1][i]);
			}
		}

		return minCost;
	}
}