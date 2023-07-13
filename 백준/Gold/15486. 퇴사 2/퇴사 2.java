import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] dp;
	private static int[][] arr;
	private static StringTokenizer st;
	private static int T;
	private static int P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 2];

		arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			T = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			arr[i][0] = T;
			arr[i][1] = P;
		}

//		System.out.println(recur(1));

		for (int i = N; i > 0; i--) {
			int date = i + arr[i][0];
			if (date <= N + 1) {
				dp[i] = Math.max(arr[i][1] + dp[date], dp[i + 1]);
			} else {
				dp[i] = dp[i + 1];
			}
		}

		System.out.println(dp[1]);
	}

//	private static int recur(int cur) {
//		if (cur > N) {
//			return 0;
//		}
//
//		if (dp[cur] != -1) {
//			return dp[cur];
//		}
//
//		if (cur + arr[cur][0] - 1 <= N) {
//			dp[cur] = Math.max(arr[cur][1] + recur(cur + arr[cur][0]), recur(cur + 1));
//		} else {
//			dp[cur] = recur(cur + 1);
//		}
//
//		return dp[cur];
//	}
}