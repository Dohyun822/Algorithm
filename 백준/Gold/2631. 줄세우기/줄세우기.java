import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static int[] dp;
	private static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		num = new int[N + 1];
		dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());

		}

		dp[0] = 0;
		int chk = 0;
		for (int i = 1; i <= N; i++) {
//			num[i] = Integer.parseInt(br.readLine());
			dp[i] = 1;
			for (int j = 1; j <= N; j++) {
				if (num[j] < num[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			chk = Math.max(chk, dp[i]);
		}

		System.out.println(N - chk);
	}
}