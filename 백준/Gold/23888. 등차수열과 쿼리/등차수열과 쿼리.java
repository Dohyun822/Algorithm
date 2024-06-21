import java.io.*;
import java.util.*;

public class Main {
	private static long a;
	private static long d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		a = Long.parseLong(st.nextToken());
		d = Long.parseLong(st.nextToken());

		int q = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int type = Integer.parseInt(st.nextToken());
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());

			if (type == 1) {
				sb.append(sum(l, r)).append("\n");
			} else {
				sb.append(solve(l, r)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	private static long sum(long l, long r) {
		long n = r - l + 1;
		long first = a + (l - 1) * d;
		long last = a + (r - 1) * d;
		return n * (first + last) / 2;
	}

	private static long solve(long l, long r) {
		if (l == r) {
			return a + (l - 1) * d;
		}
		if (d == 0) {
			return a;
		} else {
			long first = a + (l - 1) * d;
			return gcd(first, d);
		}
	}

	private static long gcd(long first, long d2) {
		while (d2 != 0) {
			long temp = d2;
			d2 = first % d2;
			first = temp;
		}
		return first;
	}
}