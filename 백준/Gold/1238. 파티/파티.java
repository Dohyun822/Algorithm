import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	private static int N;
	private static int M;
	private static int X;
	private static ArrayList<Node> node[];
	private static int[] distance;
	private static int[] answer;
	private static PriorityQueue<Node> pq;
	private static final int INF = 99999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		node = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			node[i] = new ArrayList<Node>();
		}

		distance = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			node[Integer.parseInt(st.nextToken())]
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		answer = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(distance, INF);
			distance[i] = 0;
			goX(i);
		}

		Arrays.fill(distance, INF);
		distance[X] = 0;
		goHome();

		int res = 0;
		for (int x : answer) {
			res = res < x ? x : res;
		}
		System.out.println(res);

	} // end of main

	private static void goHome() {
		pq = new PriorityQueue<Node>();
		pq.offer(new Node(X, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (Node temp : node[cur.vertex]) {
				if (distance[temp.vertex] > cur.weight + temp.weight) {
					distance[temp.vertex] = cur.weight + temp.weight;
					pq.offer(new Node(temp.vertex, distance[temp.vertex]));
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			answer[i] += distance[i];
		}

	}

	private static void goX(int i) {
		pq = new PriorityQueue<Node>();
		pq.offer(new Node(i, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (Node temp : node[cur.vertex]) {
				if (distance[temp.vertex] > cur.weight + temp.weight) {
					distance[temp.vertex] = cur.weight + temp.weight;
					pq.offer(new Node(temp.vertex, distance[temp.vertex]));
				}
			}
		}
		answer[i] += distance[X];
	}
}// end of class