import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static class Node implements Comparable<Node> {
		int vertex;
		long distance;

		public Node(int vertex, long distance) {
			this.vertex = vertex;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.distance, o.distance);
		}
	}

	private static final long INF = Long.MAX_VALUE;

	private static int N;
	private static int M;
	private static int K;

	private static ArrayList<Node>[] list;
	private static int U;
	private static int V;
	private static int C;
	private static long[] distance;

	private static int idx;

	private static long max;
	private static PriorityQueue<Node> pq;
	private static StringTokenizer st;
	private static BufferedReader br;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			U = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			list[V].add(new Node(U, C));
		}

		solve();

	}// end of main

	private static void solve() throws IOException {
		distance = new long[N + 1];
		Arrays.fill(distance, INF);
		st = new StringTokenizer(br.readLine(), " ");
		idx = 0;
		max = 0;

		pq = new PriorityQueue<Node>();
		for (int k = 0; k < K; k++) {
			int i = Integer.parseInt(st.nextToken());
			pq.offer(new Node(i, 0));
			distance[i] = 0;
		}

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (distance[cur.vertex] < cur.distance) {
				continue;
			}
			for (Node temp : list[cur.vertex]) {
				if (distance[temp.vertex] > cur.distance + temp.distance) {
					distance[temp.vertex] = cur.distance + temp.distance;
					pq.offer(new Node(temp.vertex, distance[temp.vertex]));
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (distance[i] > max) {
				max = distance[i];
				idx = i;
			}
		}
		System.out.println(idx);
		System.out.println(max);
	}
}// end of class