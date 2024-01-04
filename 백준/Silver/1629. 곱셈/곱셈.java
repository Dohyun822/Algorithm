import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		System.out.println(solve(A, B, C));
	}

	private static long solve(long a, long b, long c) {
		if (b == 1) {
			return a % c;
		}

		long val = solve(a, b / 2, c) % c;

		val = val * val % c;

		if (b % 2 == 1) {
			val = val * a % c;
		}

		return val;
	}
}
