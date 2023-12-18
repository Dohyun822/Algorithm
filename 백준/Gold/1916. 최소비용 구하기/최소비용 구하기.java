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

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	private static int N;
	private static int M;
	private static ArrayList<Node>[] graph;
	private static int[] dist;
	private static int start;
	private static int end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		dist = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(to, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		solve(start, end);

		System.out.println(dist[end]);

	}

	private static void solve(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (dist[now.vertex] < now.cost) {
				continue;
			}
			for (Node next : graph[now.vertex]) {
				if (dist[next.vertex] > now.cost + next.cost) {
					dist[next.vertex] = now.cost + next.cost;
					pq.add(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}
	}
}