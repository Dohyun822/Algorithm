import java.io.*;
import java.util.*;

public class Main {
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
			return Integer.compare(o2, o1);
		});
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}

		int answer = 0;

		while (pq.size() > 1) {
			int x = pq.poll();
			int y = pq.poll();
			int hap = x + y;
			int mul = x * y;
			answer += mul;

			pq.offer(hap);

		}

		System.out.println(answer);
	}
}