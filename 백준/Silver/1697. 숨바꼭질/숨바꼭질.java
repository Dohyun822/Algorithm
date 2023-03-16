import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static int[] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			return;
		}
		map = new int[100001];
		solve();
		System.out.println(map[K]);
	}// end of main

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(N);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur - 1 >= 0 && map[cur - 1] == 0) {
				q.offer(cur - 1);
				map[cur - 1] = map[cur] + 1;
				if (cur - 1 == K) {
					break;
				}
			}
			if (cur + 1 < 100001 && map[cur + 1] == 0) {
				q.offer(cur + 1);
				map[cur + 1] = map[cur] + 1;
				if (cur + 1 == K) {
					break;
				}
			}
			if (cur * 2 < 100001 && map[cur * 2] == 0) {
				q.offer(cur * 2);
				map[cur * 2] = map[cur] + 1;
				if (cur * 2 == K) {
					break;
				}
			}
		}
	}
}// end of class