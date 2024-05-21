import java.io.*;
import java.util.*;

public class Main {
	private static Boolean[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new Boolean[N + 1];
		Arrays.fill(dp, null);

		if (recur(N)) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

	private static boolean recur(int n) {
		if (n < 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}

		if (dp[n] != null) {
			return dp[n];
		}

		boolean canWin = !recur(n - 1) || !recur(n - 3) || !recur(n - 4);
		dp[n] = canWin;

		return canWin;
	}
}
