import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] selected;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		selected = new int[M];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		solve(0, 0, 0);

		System.out.println(sb.toString());

	}

	private static void solve(int start, int cnt, int flag) {
		if (cnt == M) {
			for (int i : selected) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return;
		}
		for (int i = start; i < N; i++) {
//			if ((flag & 1 << i) != 0)
//				continue;
			selected[cnt] = arr[i];

			solve(start, cnt + 1, flag | 1 << i);
		}
	}
}