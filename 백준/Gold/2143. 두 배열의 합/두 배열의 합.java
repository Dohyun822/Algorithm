import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.xml.sax.HandlerBase;

import java.io.IOException;

public class Main {
	private static int T;
	private static int n;
	private static int[] A;
	private static int m;
	private static int[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		n = Integer.parseInt(br.readLine());

		A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		B = new int[m];
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		long result = 0;

		HashMap<Long, Long> hashmap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				hashmap.put(sum, hashmap.getOrDefault(sum, 0L) + 1);
			}
		}

		for (int i = 0; i < m; i++) {
			long sum = 0;
			for (int j = i; j < m; j++) {
				sum += B[j];
				long t = T - sum;
				result += hashmap.getOrDefault(t, 0L);
			}
		}

		System.out.println(result);

	}
}