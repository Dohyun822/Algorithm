import java.io.*;
import java.util.*;

public class Main {

	private static int N;
	private static int M;
	private static int[][] prefix_sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		prefix_sum = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				prefix_sum[i][j] = Integer.parseInt(st.nextToken()) + prefix_sum[i][j - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());

			int hap = 0;
			for (int r = startY; r <= endY; r++) {
				hap += prefix_sum[r][endX] - prefix_sum[r][startX - 1];
			}
			sb.append(hap).append("\n");
		}

		System.out.println(sb.toString());

	}
}