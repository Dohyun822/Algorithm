import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int[][] skills;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		skills = new int[n][5];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				skills[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[n][1 << 5];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		int result = solve(0, 0);
		System.out.println(result);
	}

	private static int solve(int person, int mask) {
		if (person == n) {
			if (mask == (1 << 5) - 1) {
				return 0;
			} else {
				return -1000000000;
			}
		}

		if (dp[person][mask] != -1) {
			return dp[person][mask];
		}

		int result = solve(person + 1, mask);

		for (int role = 0; role < 5; role++) {
			if ((mask & (1 << role)) == 0) {
				result = Math.max(result, skills[person][role] + solve(person + 1, mask | (1 << role)));
			}
		}

		dp[person][mask] = result;
		return result;
	}
}