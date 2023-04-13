import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int student;
		Node link;

		public Node(int student, Node link) {
			this.student = student;
			this.link = link;
		}

	}

	private static int N;
	private static int M;
	private static Node[] line;
	private static int[] linkCnt;
	private static int A;
	private static int B;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		line = new Node[N + 1];
		linkCnt = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			line[A] = new Node(B, line[A]);
			linkCnt[B]++;
		}

		solve();

		System.out.println(sb.toString());

	}

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if (linkCnt[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			for (Node temp = line[cur]; temp != null; temp = temp.link) {
				if (--linkCnt[temp.student] == 0) {
					q.offer(temp.student);
				}
			}
		}
	}
}