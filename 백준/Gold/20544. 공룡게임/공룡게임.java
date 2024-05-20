import java.io.*;
import java.util.*;

public class Main {
	private static final int MOD = 1000000007;
	private static int N;
	private static Integer[][][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1][3][3][2];
		System.out.println(recur(0, 0, 0, false));
	}

	private static int recur(int cur, int first, int second, boolean chk) {
		if (cur == N - 1) {
			return chk ? 1 : 0;
		}
		if (dp[cur][first][second][chk ? 1 : 0] != null) {
			return dp[cur][first][second][chk ? 1 : 0];
		}

		int result = 0;
		if (first == 0) {
			result = (result + recur(cur + 1, 0, first, chk)) % MOD;
			result = (result + recur(cur + 1, 1, first, chk)) % MOD;
			result = (result + recur(cur + 1, 2, first, true)) % MOD;
		} else if (first == 1) {
			if (second == 0) {
				result = (result + recur(cur + 1, 0, first, chk)) % MOD;
				result = (result + recur(cur + 1, 1, first, chk)) % MOD;
				result = (result + recur(cur + 1, 2, first, true)) % MOD;
			} else {
				result = (result + recur(cur + 1, 0, first, chk)) % MOD;
			}
		} else if (first == 2) {
			if (second == 0) {
				result = (result + recur(cur + 1, 0, first, chk)) % MOD;
				result = (result + recur(cur + 1, 1, first, chk)) % MOD;
			} else {
				result = (result + recur(cur + 1, 0, first, chk)) % MOD;
			}
		}

		dp[cur][first][second][chk ? 1 : 0] = result;
		return result;
	}
}