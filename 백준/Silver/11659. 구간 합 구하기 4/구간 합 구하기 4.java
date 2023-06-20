import java.io.*;
import java.util.*;

public class Main {

	private static int N;
	private static int M;
	private static int[] prefix_sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		prefix_sum = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			prefix_sum[i] += Integer.parseInt(st.nextToken()) + prefix_sum[i - 1];
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(prefix_sum[end] - prefix_sum[start - 1]).append("\n");
		}

		System.out.println(sb.toString());

	}
}