import java.io.*;
import java.util.*;

public class Main {
	private static int[] arr;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N][N];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(minInsertions(0, N - 1));
	}

	private static int minInsertions(int left, int right) {
		if (left >= right) {
			return 0;
		}

		if (dp[left][right] != -1) {
			return dp[left][right];
		}

		if (arr[left] == arr[right]) {
			dp[left][right] = minInsertions(left + 1, right - 1);
		} else {
			dp[left][right] = Math.min(minInsertions(left + 1, right), minInsertions(left, right - 1)) + 1;
		}

		return dp[left][right];
	}
}
