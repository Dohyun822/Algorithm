import java.io.*;
import java.util.*;

public class Main {
	private static int T;
	private static int W;
	private static int[] arr;
	private static Integer[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		arr = new int[T + 1];
		for (int i = 1; i <= T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp = new Integer[T + 1][W + 1][3];

		System.out.println(Math.max(recur(T, W, 1), recur(T, W - 1, 2)));

	}

	private static int recur(int time, int moveCnt, int cur) {
		if (time == 0) {
			return 0;
		}
		if (dp[time][moveCnt][cur] != null) {
			return dp[time][moveCnt][cur];
		}

		int jadu = arr[time] == cur ? 1 : 0;

		int notMove = jadu + recur(time - 1, moveCnt, cur);
		int move = 0;

		if (moveCnt > 0) {
			move = jadu + recur(time - 1, moveCnt - 1, cur == 1 ? 2 : 1);
		}

		dp[time][moveCnt][cur] = Math.max(notMove, move);
		return dp[time][moveCnt][cur];
	}
}
