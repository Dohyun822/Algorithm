import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		dp = new long[N + 1][N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[1][2][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				if (map[i][j] == 0) {
					if (j + 1 <= N && map[i][j + 1] == 0) {
						dp[i][j + 1][0] += dp[i][j][0] + dp[i][j][2];
					}
					if (i + 1 <= N && map[i + 1][j] == 0) {
						dp[i + 1][j][1] += dp[i][j][1] + dp[i][j][2];
					}
					if (i + 1 <= N && j + 1 <= N && map[i + 1][j] == 0 && map[i][j + 1] == 0
							&& map[i + 1][j + 1] == 0) {
						dp[i + 1][j + 1][2] += dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
					}
				}
			}
		}

		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
}