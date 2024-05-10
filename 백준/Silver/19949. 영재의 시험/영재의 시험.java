import java.io.*;
import java.util.*;

public class Main {
	private static int cnt;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		cnt = 0;

		arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, 0, 0, 0);

		System.out.println(cnt);

	}

	private static void solve(int cur, int jumsu, int first, int second) {
		if (cur == 10) {
			if (jumsu >= 5) {
				cnt++;
			}
			return;
		}

		for (int i = 1; i <= 5; i++) {
			if (first == second && first == i) {
				continue;
			}
			if (arr[cur] == i) {
				solve(cur + 1, jumsu + 1, i, first);
			} else {
				solve(cur + 1, jumsu, i, first);
			}
		}
	}

}