import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = { 1, 2, 3 };
	static int k;
	static int n;
	static int cnt;
	static int[] answer;
	static StringBuilder sb = new StringBuilder();
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		answer = new int[11];
		findmax(0);
		if (k > max) {
			System.out.println(-1);
			return;
		}
		solve(0, 0);

		System.out.println(sb.toString());
	} // end of main

	private static void findmax(int sum) {
		if (sum == n) {
			max++;
			return;
		} else if (sum > n) {
			return;
		} else {
			for (int i = 0; i < arr.length; i++) {
				findmax(sum + arr[i]);
			}
		}
	}

	private static void solve(int count, int sum) {
		if (sum == n) {
			cnt++;
			if (cnt == k) {
				int hap = 0;
				for (int x : answer) {
					sb.append(x);
					hap += x;
					if (hap == n) {
						return;
					}
					sb.append("+");
				}
			}
			return;
		} else if (sum > n) {
			return;
		} else {
			for (int i = 0; i < arr.length; i++) {
				answer[count] = arr[i];
				solve(count + 1, sum + arr[i]);

			}
		}
	}
}// end of class
