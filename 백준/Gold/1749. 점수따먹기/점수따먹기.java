import java.io.*;
import java.util.*;

public class Main {
	private static int c;
	private static int N;
	private static int M;
	private static int[][] arr;
	private static int[][] prefix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		prefix = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				prefix[i][j] = prefix[i - 1][j] + arr[i][j];
			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				int sum = 0;
				for (int k = 1; k <= M; k++) {
					if (sum < 0)
						sum = prefix[j][k] - prefix[i - 1][k];
					else
						sum += prefix[j][k] - prefix[i - 1][k];
					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);

	}
}