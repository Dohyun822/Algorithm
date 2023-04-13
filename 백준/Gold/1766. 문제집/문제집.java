import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num;
		Node node;

		public Node(int num, Node node) {
			this.num = num;
			this.node = node;
		}

	}

	private static int N;
	private static int M;
	private static Node[] pro;
	private static int[] linkCnt;
	private static int A;
	private static int B;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pro = new Node[N + 1];
		linkCnt = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			pro[A] = new Node(B, pro[A]);
			linkCnt[B]++;
		}

		solve();

		System.out.println(sb.toString());

	}

	private static void solve() {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 1; i <= N; i++) {
			if (linkCnt[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			for (Node temp = pro[cur]; temp != null; temp = temp.node) {
				if (--linkCnt[temp.num] == 0) {
					q.offer(temp.num);
				}
			}
		}
	}
}