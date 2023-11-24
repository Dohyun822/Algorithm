import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		solve(arr, 0, 0);

		System.out.println(sb.toString());
	}

	private static void solve(int[] num, int cnt, int flag) {
		if (cnt == M) {
			for (int i : selected) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
		} else {
			for (int i = 0; i < num.length; i++) {
				if ((flag & 1 << i) != 0)
					continue;
				selected[cnt] = num[i];
				solve(num, cnt + 1, flag | 1 << i);
			}
		}
	}
}