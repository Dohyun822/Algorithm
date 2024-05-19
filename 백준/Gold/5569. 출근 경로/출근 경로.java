import java.io.*;
import java.util.*;

public class Main {
	private static final int MOD = 100000;
	private static int w;
	private static int h;
	private static int answer = 0;
	private static long[][][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		dp = new long[w + 1][h + 1][2][2];

		for (int i = 0; i <= w; i++) {
			for (int j = 0; j <= h; j++) {
				Arrays.fill(dp[i][j][0], -1);
				Arrays.fill(dp[i][j][1], -1);
			}
		}

		recur(1, 1, 0, 0);
		recur(1, 1, 1, 0);

		System.out.println((recur(1, 1, 0, 0) + recur(1, 1, 1, 0)) % MOD);
	}

	static long recur(int x, int y, int dir, int canChange) {
		if (x > w || y > h)
			return 0;
		if (x == w && y == h) {
			return 1;
		}

		if (dp[x][y][dir][canChange] != -1) {
			return dp[x][y][dir][canChange];
		}

		long count = 0;

		if (dir == 0) {
			count = count + recur(x, y + 1, 0, 1) % MOD;
		} else {
			count = count + recur(x + 1, y, 1, 1) % MOD;
		}

		if (canChange == 1) {
			if (dir == 0) {
				count = (count + recur(x + 1, y, 1, 0)) % MOD;
			} else {
				count = (count + recur(x, y + 1, 0, 0)) % MOD;
			}
		}

		dp[x][y][dir][canChange] = count;
		return dp[x][y][dir][canChange];
	}
}