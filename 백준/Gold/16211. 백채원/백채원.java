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

	private static int N;
	private static int M;
	private static int K;
	private static ArrayList<Node>[] graphs;
	private static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graphs = new ArrayList[N + 1];
		dist = new int[K + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			graphs[i] = new ArrayList<Node>();
		}

		for (int i = 0; i <= K; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			graphs[A].add(new Node(B, T));
			graphs[B].add(new Node(A, T));
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i <= K; i++) {
			if (i == 0) {
				dijkstra(i, 1);
			} else {
				dijkstra(i, Integer.parseInt(st.nextToken()));
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 2; i <= N; i++) {
			int curCost = dist[0][i];
			boolean chk = true;
			for (int j = 1; j <= K; j++) {
				if (curCost >= dist[j][i]) {
					chk = false;
					break;
				}
			}
			if (chk) {
				sb.append(i).append(" ");
			}
		}

		if (sb.length() == 0) {
			System.out.println(0);
		} else {
			System.out.println(sb.toString());
		}
	}

	private static void dijkstra(int idx, int n) {
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		pq.offer(new Node(n, 0));
		dist[idx][n] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (Node next : graphs[cur.vertex]) {
				if (dist[idx][next.vertex] > next.cost + dist[idx][cur.vertex]) {
					dist[idx][next.vertex] = next.cost + dist[idx][cur.vertex];
					pq.offer(new Node(next.vertex, dist[idx][next.vertex]));
				}
			}
		}
	}
}