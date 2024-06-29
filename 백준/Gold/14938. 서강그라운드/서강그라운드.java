import java.io.*;
import java.util.*;

public class Main {
	public static class Node implements Comparable<Node> {
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
	private static int r;
	private static int[] item;
	private static ArrayList<Node>[] graphs;
	private static int[] dist;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		item = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		graphs = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graphs[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graphs[start].add(new Node(end, cost));
			graphs[end].add(new Node(start, cost));
		}

		answer = 0;

		for (int i = 1; i <= n; i++) {
			dijkstra(i);
		}

		System.out.println(answer);

	}

	private static void dijkstra(int i) {
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[i] = 0;
		pq.offer(new Node(i, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (Node next : graphs[cur.vertex]) {
				if (dist[next.vertex] > cur.cost + next.cost) {
					dist[next.vertex] = cur.cost + next.cost;
					pq.offer(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}

		int temp = 0;
		for (int j = 1; j <= n; j++) {
			if (dist[j] <= m) {
				temp += item[j];
			}
		}

		answer = Math.max(answer, temp);

	}
}
