import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a, b) -> a[0] - b[0]);

		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i][1] > arr[j][1]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(dp[i], max);
		}

		System.out.println(N - max);

	}
}