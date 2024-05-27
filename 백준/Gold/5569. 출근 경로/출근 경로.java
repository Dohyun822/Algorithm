import java.io.*;
import java.util.*;

public class Main {
	private static final int MOD = 100000;
	private static int w;
	private static int h;
	private static long[][][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		dp = new long[w + 1][h + 1][2][2];

		for (int i = 1; i <= w; i++) {
			for (int j = 1; j <= h; j++) {
				dp[i][j][0][0] = 0;
				dp[i][j][0][1] = 0;
				dp[i][j][1][0] = 0;
				dp[i][j][1][1] = 0;
			}
		}

		dp[1][1][0][0] = 1;
		dp[1][1][1][0] = 1;

		for (int x = 1; x <= w; x++) {
			for (int y = 1; y <= h; y++) {
				for (int dir = 0; dir < 2; dir++) {
					for (int canChange = 0; canChange < 2; canChange++) {
						if (dp[x][y][dir][canChange] > 0) {
							if (dir == 0) { // 수평 방향
								if (y + 1 <= h) {
									dp[x][y + 1][0][1] = (dp[x][y + 1][0][1] + dp[x][y][0][canChange]) % MOD;
								}
								if (canChange == 1 && x + 1 <= w) {
									dp[x + 1][y][1][0] = (dp[x + 1][y][1][0] + dp[x][y][0][canChange]) % MOD;
								}
							} else { // 수직 방향
								if (x + 1 <= w) {
									dp[x + 1][y][1][1] = (dp[x + 1][y][1][1] + dp[x][y][1][canChange]) % MOD;
								}
								if (canChange == 1 && y + 1 <= h) {
									dp[x][y + 1][0][0] = (dp[x][y + 1][0][0] + dp[x][y][1][canChange]) % MOD;
								}
							}
						}
					}
				}
			}
		}

		long result = (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % MOD;
		System.out.println(result);
	}
}