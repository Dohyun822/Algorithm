import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int K;
	private static int[] dist;
	private static int[] prev;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dist = new int[100001];
		prev = new int[100001];

		Arrays.fill(dist, Integer.MAX_VALUE);

		solve();

		System.out.println(dist[K]);

		path();
	}

	private static void path() {
		Stack<Integer> stack = new Stack<>();
		int cur = K;
		while (cur != N) {
			stack.push(cur);
			cur = prev[cur];
		}
		stack.push(N);

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(N);

		dist[N] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == K) {
				return;
			}
			int left = cur - 1;
			int right = cur + 1;
			int move = cur * 2;

			if (left >= 0 && dist[left] > dist[cur] + 1) {
				dist[left] = dist[cur] + 1;
				prev[left] = cur;
				q.offer(left);
			}
			if (right <= 100000 && dist[right] > dist[cur] + 1) {
				dist[right] = dist[cur] + 1;
				prev[right] = cur;
				q.offer(right);
			}
			if (move >= 0 && move <= 100000 && dist[move] > dist[cur]) {
				dist[move] = dist[cur] + 1;
				prev[move] = cur;
				q.offer(move);
			}
		}
	}
}