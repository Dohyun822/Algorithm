import java.io.*;
import java.util.*;

public class Main {
	public static class Node implements Comparable<Node> {
		int vertex;
		Long cost;
		int discomfort;

		public Node(int vertex, Long cost, int discomfort) {
			this.vertex = vertex;
			this.cost = cost;
			this.discomfort = discomfort;
		}

		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	private static int N;
	private static int M;
	private static int T;
	private static ArrayList<Main.Node>[] graph;
	private static Long[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		dist = new Long[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			Long t = Long.parseLong(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, t, s));
			graph[v].add(new Node(u, t, s));
		}
		int answer = getDiscomfort();

		System.out.println(answer > 1000000000 ? -1 : answer);
	}

	private static int getDiscomfort() {
		int left = 0;
		int right = 1000000000;
		int answer = right + 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (solve(mid)) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}

	private static boolean solve(int discomfort) {
		Arrays.fill(dist, Long.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		pq.offer(new Node(1, 0L, 0));
		dist[1] = 0L;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.vertex == N) {
				return dist[N] <= T;
			}
			if (dist[cur.vertex] < cur.cost) {
				continue;
			}
			for (Node next : graph[cur.vertex]) {
				Long nextCost = cur.cost + next.cost + Math.max(0, next.discomfort - discomfort);

				if (nextCost <= T && dist[next.vertex] > nextCost) {
					dist[next.vertex] = nextCost;
					pq.offer(new Node(next.vertex, nextCost, next.discomfort));
				}
			}
		}

		return false;

	}
}