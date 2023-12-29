import java.util.*;
import java.io.*;

public class Main {
	public static class Node implements Comparable<Node> {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	private static ArrayList<Node>[] arr;
	private static int[][] dist;
	private static int[][] path;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			arr[from].add(new Node(to, weight));
			arr[to].add(new Node(from, weight));
		}

		dist = new int[n][n];
		path = new int[n][n];

		for (int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		for (int i = 0; i < n; i++) {
			dijkstra(i);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					System.out.print("- ");
				} else {
					System.out.print(path[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[arr.length];

		pq.add(new Node(start, 0));
		dist[start][start] = 0;
		Arrays.fill(path[start], start);

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int v = current.vertex;

			if (visited[v])
				continue;
			visited[v] = true;

			for (Node node : arr[v]) {
				int next = node.vertex;
				int weight = node.weight;
				if (dist[start][next] > dist[start][v] + weight) {
					dist[start][next] = dist[start][v] + weight;
					pq.offer(new Node(next, dist[start][next]));
					if (start == v) {
						path[start][next] = next + 1;
					} else {
						path[start][next] = path[start][v];
					}
				}
			}
		}
	}

}