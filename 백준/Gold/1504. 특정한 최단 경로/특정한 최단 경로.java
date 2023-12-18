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
	private static int E;
	private static ArrayList<Node>[] graph;
	private static int[] dist;
	private static int v1;
	private static int v2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		dist = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine(), " ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		int distance1 = solve(1, v1) + solve(v1, v2) + solve(v2, N);
		int distance2 = solve(1, v2) + solve(v2, v1) + solve(v1, N);

		if (distance1 >= 99999999 || distance2 >= 99999999) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(distance1, distance2));
		}

	}

	private static int solve(int start, int end) {
		Arrays.fill(dist, 99999999);
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
		return dist[end];
	}

}