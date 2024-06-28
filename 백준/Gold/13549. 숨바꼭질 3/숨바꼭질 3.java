import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int K;
	private static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dist = new int[100001];

		Arrays.fill(dist, Integer.MAX_VALUE);

		solve();

		System.out.println(dist[K]);
	}

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(N);

		dist[N] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			int left = cur - 1;
			int right = cur + 1;
			int move = cur * 2;

			if (left >= 0 && dist[left] > dist[cur] + 1) {
				dist[left] = dist[cur] + 1;
				q.offer(left);
			}
			if (right <= 100000 && dist[right] > dist[cur] + 1) {
				dist[right] = dist[cur] + 1;
				q.offer(right);
			}
			if (move >= 0 && move <= 100000 && dist[move] > dist[cur]) {
				dist[move] = dist[cur];
				q.offer(move);
			}
		}
	}
}