import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int build;
		Node next;

		public Node(int build, Node next) {
			this.build = build;
			this.next = next;
		}
	}

	private static int T;
	private static int N;
	private static int K;
	private static int[] cost;
	private static int[] link;
	private static Node[] node;
	private static int X;
	private static int Y;
	private static int W;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			cost = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			node = new Node[N + 1];
			link = new int[N + 1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());

				node[X] = new Node(Y, node[X]);
				link[Y]++;
			}
			W = Integer.parseInt(br.readLine());

			if (link[W] == 0) {
				sb.append(cost[W]).append("\n");
				continue;
			}

			solve();

		} // end of tc
		System.out.println(sb.toString());
	}// end of main

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		int[] res = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			res[i] = cost[i];
			if (link[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Node temp = node[cur]; temp != null; temp = temp.next) {
				res[temp.build] = res[temp.build] > res[cur] + cost[temp.build] ? res[temp.build]
						: res[cur] + cost[temp.build];
				if (--link[temp.build] == 0) {
					q.offer(temp.build);
				}
			}
		}

		sb.append(res[W]).append("\n");
	}
}// end of class