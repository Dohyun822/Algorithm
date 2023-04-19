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

	private static final int INF = 99999999;

	private static int N;
	private static int M;
	private static int X;
	private static ArrayList<Node>[] list;
	private static ArrayList<Node>[] reverseList;
	private static int answer;
	private static int A;
	private static int B;
	private static int W;
	private static int[] distance;
	private static int[] reverseDis;

	private static PriorityQueue<Node> pq;
	private static PriorityQueue<Node> reversepq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		reverseList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
			reverseList[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			list[A].add(new Node(B, W));
			reverseList[B].add(new Node(A, W));
		}

		answer = 0;

		solve();

		for (int i = 1; i <= N; i++) {
			answer = distance[i] + reverseDis[i] > answer ? distance[i] + reverseDis[i] : answer;
		}
		System.out.println(answer);

	}

	private static void solve() {
		distance = new int[N + 1];
		reverseDis = new int[N + 1];
		Arrays.fill(distance, INF);
		Arrays.fill(reverseDis, INF);

		pq = new PriorityQueue<Node>();
		reversepq = new PriorityQueue<Node>();
		pq.offer(new Node(X, 0));
		reversepq.offer(new Node(X, 0));
		distance[X] = 0;
		reverseDis[X] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (Node temp : list[cur.vertex]) {
				if (distance[temp.vertex] > temp.weight + cur.weight) {
					distance[temp.vertex] = temp.weight + cur.weight;
					pq.offer(new Node(temp.vertex, distance[temp.vertex]));
				}

			}
		}

		while (!reversepq.isEmpty()) {
			Node cur = reversepq.poll();
			for (Node temp : reverseList[cur.vertex]) {
				if (reverseDis[temp.vertex] > temp.weight + cur.weight) {
					reverseDis[temp.vertex] = temp.weight + cur.weight;
					reversepq.offer(new Node(temp.vertex, reverseDis[temp.vertex]));
				}

			}
		}
	}
}