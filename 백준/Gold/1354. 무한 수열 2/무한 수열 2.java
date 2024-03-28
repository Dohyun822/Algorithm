import java.io.*;
import java.util.*;

public class Main {
	private static long N;
	private static long P;
	private static long Q;
	private static Map<Long, Long> memo = new HashMap<>();
	private static long X;
	private static long Y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());

		System.out.println(findA(N));
	}

	private static long findA(long i) {
		if (i <= 0) {
			return 1;
		}

		if (memo.containsKey(i)) {
			return memo.get(i);
		}

		long result = findA((i / P) - X) + findA((i / Q) - Y);

		memo.put(i, result);

		return result;
	}
}
