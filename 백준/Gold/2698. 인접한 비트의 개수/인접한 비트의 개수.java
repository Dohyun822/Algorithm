import java.io.*;
import java.util.*;

public class Main {
	private static int T;
	private static int n;
	private static int k;
	private static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			dp = new int[n + 1][k + 1][2];
			for (int[][] layer : dp)
				for (int[] row : layer)
					Arrays.fill(row, -1);

			int answer = recur(0, 0, 0) + recur(0, 0, 1);
			sb.append(answer).append('\n');
		}

		System.out.println(sb.toString());
		br.close();
	}

	private static int recur(int idx, int bitCnt, int lastBit) {
		if (idx == n - 1) {
			return (bitCnt == k) ? 1 : 0;
		}
		if (bitCnt > k) {
			return 0;
		}
		if (dp[idx][bitCnt][lastBit] != -1) {
			return dp[idx][bitCnt][lastBit];
		}

		int count = recur(idx + 1, bitCnt, 0);

		if (lastBit == 1) {
			count += recur(idx + 1, bitCnt + 1, 1);
		} else {
			count += recur(idx + 1, bitCnt, 1);
		}

		dp[idx][bitCnt][lastBit] = count;
		return dp[idx][bitCnt][lastBit];
	}
}