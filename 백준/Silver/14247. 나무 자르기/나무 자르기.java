import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] H = new long[n];
		long[] A = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			H[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
		for (int i = 0; i < n; i++) {
			pq.offer(new long[] { H[i], A[i] });
		}

		long totalWood = 0;
		for (int day = 1; day <= n; day++) {
			long[] tree = pq.poll();
			totalWood += tree[0] + (day - 1) * tree[1];
		}

		System.out.println(totalWood);
	}
}