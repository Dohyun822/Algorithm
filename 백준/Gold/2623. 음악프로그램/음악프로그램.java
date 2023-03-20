import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

	}

	private static int N;
	private static int M;
	static int[] cnt;
	static Node[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new Node[N + 1];
		cnt = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			for (int j = 1; j < x; j++) {
				int to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				cnt[to]++;
				from = to;
			}
		}

		ArrayList<Integer> list = solve();
		if (list.size() != N) {
			System.out.println(0);
			return;
		}
		for (Integer x : list) {
			System.out.println(x);
		}

	} // end of main

	private static ArrayList<Integer> solve() {
		ArrayList<Integer> order = new ArrayList<Integer>();
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i < cnt.length; i++) {
			if (cnt[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			order.add(cur);

			for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if (--cnt[temp.vertex] == 0) {
					q.offer(temp.vertex);
				}
			}

		}
		return order;
	}
}// end of class