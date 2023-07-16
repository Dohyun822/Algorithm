import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] dp = new int[3][N];
		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		dp[0][0] = R;
		dp[1][0] = G;
		dp[2][0] = B;

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + R;
			dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + G;
			dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + B;
		}

		int temp = Math.min(dp[0][N - 1], dp[1][N - 1]);
		System.out.println(Math.min(temp, dp[2][N - 1]));
	}// end of main
}// end of class