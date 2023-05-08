import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int T;
	private static int N;
	private static int[] arr;
	private static StringTokenizer st;
	private static int[] dp;
	private static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			dp = new int[10001];
			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = arr[i]; j <= M; j++) {
					dp[j] += dp[j - arr[i]];
				}
			}
			System.out.println(dp[M]);

		}
	}// end of main
}// end of class