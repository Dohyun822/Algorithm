import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean check(int x, int[] arr, int n) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (total > x) {
				return false;
			}
			total += arr[i];
			if (total == x) {
				total = 0;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int mmax = 0;
			int total = 0;
			int zero_cnt = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (mmax < arr[i]) {
					mmax = arr[i];
				}
				if (arr[i] == 0) {
					zero_cnt += 1;
				}
				total += arr[i];
			}

			int ans = 0;
			for (int i = Math.max(1, mmax); i <= total; i++) {
				if (total % i == 0 && check(i, arr, n)) {
					ans = n - total / i;
					break;
				}
			}

			System.out.println(ans);
		}
	}
}