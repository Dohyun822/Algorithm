import java.io.*;
import java.util.*;

public class Main {
	static int[] b = new int[3];
	static Integer[][] dp = new Integer[501][501];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 3; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			int k1 = Integer.parseInt(st.nextToken());
			int k2 = Integer.parseInt(st.nextToken());
			System.out.println(solve(k1, k2) ? "A" : "B");
		}
	}

	static boolean solve(int k1, int k2) {
		if (k1 < 0 || k2 < 0)
			return true;
		if (k1 == 0 && k2 == 0)
			return false;
		if (dp[k1][k2] != null)
			return dp[k1][k2] == 1;

		for (int i = 0; i < 3; i++) {
			if (!solve(k1 - b[i], k2) || !solve(k1, k2 - b[i])) {
				dp[k1][k2] = 1;
				return true;
			}
		}

		dp[k1][k2] = 0;
		return false;
	}
}
