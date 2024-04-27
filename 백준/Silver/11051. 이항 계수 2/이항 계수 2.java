import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][K + 1];

		int result = binomialCoefficient(N, K);

		System.out.println(result);
	}

	private static int binomialCoefficient(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}

		if (dp[n][k] != 0) {
			return dp[n][k];
		}
		dp[n][k] = (binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k)) % 10007;

		return dp[n][k];
	}
}