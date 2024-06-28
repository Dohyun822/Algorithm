import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int K;
	private static int[] dist;
	private static int[] ways;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dist = new int[100001];
		ways = new int[100001];

		Arrays.fill(dist, Integer.MAX_VALUE);

		solve();

		System.out.println(dist[K]);
		System.out.println(ways[K]);
	}

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(N);
		dist[N] = 0;
		ways[N] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			int curDist = dist[cur];

			int left = cur - 1;
			int right = cur + 1;
			int move = cur * 2;

			int[] nextPositions = { left, right, move };

			for (int next : nextPositions) {
				if (next >= 0 && next <= 100000) {
					if (dist[next] > curDist + 1) {
						dist[next] = curDist + 1;
						ways[next] = ways[cur];
						q.offer(next);
					} else if (dist[next] == curDist + 1) {
						ways[next] += ways[cur];
					}
				}
			}
		}
	}
}