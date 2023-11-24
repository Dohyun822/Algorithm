import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] selected;
	private static StringBuilder sb;
	private static HashSet<String> hash;

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
		hash = new HashSet<String>();

		solve(0, 0, 0);

		System.out.println(sb.toString());

	}

	private static void solve(int start, int cnt, int flag) {
		if (cnt == M) {
			StringBuilder sb2 = new StringBuilder();
			for (int i : selected) {
				sb2.append(i).append(" ");
			}
			sb2.append('\n');
			if (!hash.add(sb2.toString())) {
				return;
			}
			sb.append(sb2.toString());
			return;
		}
		for (int i = start; i < N; i++) {
//			if ((flag & 1 << i) != 0)
//				continue;
			selected[cnt] = arr[i];

			solve(i, cnt + 1, flag | 1 << i);
		}
	}
}