import java.io.*;
import java.util.*;

public class Main {
	private static int[] answer = new int[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		solve();

		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(answer[N]).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void solve() {
		answer[1] = 3;
		for (int i = 2; i <= 1000; i++) {
			int cnt = 0;
			for (int j = 1; j <= i; j++) {
				if (gcd(i, j) == 1) {
					cnt++;
				}
			}
			answer[i] = answer[i - 1] + cnt * 2;
		}
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}