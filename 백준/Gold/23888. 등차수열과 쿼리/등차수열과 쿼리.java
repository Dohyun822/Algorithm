import java.io.*;
import java.util.*;

public class Main {
	private static int a;
	private static int d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		int q = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int type = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			if (type == 1) {
				sb.append(sum(l, r)).append("\n");
			} else {
				sb.append(solve(l, r)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	private static long sum(int l, int r) {
		int n = r - l + 1;
		long first = a + (l - 1) * d;
		long last = a + (r - 1) * d;
		return n * (first + last) / 2;
	}

	private static int solve(int l, int r) {
		if (l == r) {
			return a + (l - 1) * d;
		}
		if (d == 0) {
			return a;
		} else {
			int first = a + (l - 1) * d;
			return gcd(first, d);
		}
	}

	private static int gcd(int x, int y) {
		while (y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}
}