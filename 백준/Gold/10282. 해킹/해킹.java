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
	private static int d;
	private static int c;

	private static ArrayList<Node>[] graphs;
	private static int[] time;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			graphs = new ArrayList[n + 1];
			time = new int[n + 1];
			visited = new boolean[n + 1];

			for (int j = 1; j <= n; j++) {
				graphs[j] = new ArrayList<>();
				time[j] = Integer.MAX_VALUE;
			}

			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				graphs[b].add(new Node(a, s));
			}

			dijkstra(c);

			int totalCom = 0;
			int totalTime = 0;
			for (int j = 1; j <= n; j++) {
				if (time[j] != Integer.MAX_VALUE) {
					totalCom++;
					totalTime = Math.max(totalTime, time[j]);
				}
			}

			System.out.println(totalCom + " " + totalTime);
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		time[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (visited[cur.vertex]) {
				continue;
			}
			visited[cur.vertex] = true;

			for (Node next : graphs[cur.vertex]) {
				if (time[next.vertex] > time[cur.vertex] + next.cost) {
					time[next.vertex] = time[cur.vertex] + next.cost;
					pq.add(new Node(next.vertex, time[next.vertex]));
				}
			}
		}
	}
}
