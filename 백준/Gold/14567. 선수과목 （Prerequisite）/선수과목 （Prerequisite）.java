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
		Node node;

		public Node(int vertex, Node node) {
			this.vertex = vertex;
			this.node = node;
		}
	}

	private static int N;
	private static int M;
	private static Node[] list;
	private static int[] linkCnt;
	private static int A;
	private static int B;
	private static Queue<Integer> q;
	private static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new Node[N + 1];
		linkCnt = new int[N + 1];
		answer = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			list[A] = new Node(B, list[A]);
			linkCnt[B]++;
		}

		solve();

		for (int i = 1; i <= N; i++) {
			System.out.print(answer[i] + " ");
		}

	} // end of main

	private static void solve() {
		int seme = 1;
		q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if (linkCnt[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int x = q.size();
			for (int i = 0; i < x; i++) {
				int cur = q.poll();
				answer[cur] = seme;
				for (Node link = list[cur]; link != null; link = link.node) {
					if (--linkCnt[link.vertex] == 0) {
						q.offer(link.vertex);
					}
				}
			}
			seme++;
		}
	}
}// end of class