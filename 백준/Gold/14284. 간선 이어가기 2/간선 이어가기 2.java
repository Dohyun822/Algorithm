import java.io.*;
import java.util.*;

public class Main {
	private static class Node implements Comparable<Node> {
		int vertex;
		int cost;

		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	private static int n;
	private static int m;
	private static int[] dist;
	private static ArrayList<Node>[] graph;
	private static int s;
	private static int t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Node>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine(), " ");
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		solve();

		System.out.println(dist[t]);
	}

	private static void solve() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		dist[s] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dist[cur.vertex] < cur.cost) {
				continue;
			}
			for (Node next : graph[cur.vertex]) {
				if (dist[next.vertex] > cur.cost + next.cost) {
					dist[next.vertex] = cur.cost + next.cost;
					pq.offer(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}

	}
}
