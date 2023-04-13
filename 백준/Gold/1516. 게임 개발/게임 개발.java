import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num;
		Node link;

		public Node(int num, Node link) {
			this.num = num;
			this.link = link;
		}
	}

	private static int N;
	private static int[] require;
	private static Node[] build;
	private static int[] linkCnt;
	private static StringBuilder sb;
	private static int[] res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		require = new int[N + 1];
		build = new Node[N + 1];
		linkCnt = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int time = Integer.parseInt(st.nextToken());
			require[i] = time;
			while (true) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == -1) {
					break;
				} else {
					build[temp] = new Node(i, build[temp]);
					linkCnt[i]++;
				}
			}

		}

		solve();
		System.out.println(sb.toString());

	}// end of main

	private static void solve() {
		res = new int[N + 1];
		Queue<Integer> q = new ArrayDeque<Integer>();

		for (int i = 1; i <= N; i++) {
			res[i] = require[i];
			if (linkCnt[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Node temp = build[cur]; temp != null; temp = temp.link) {
				res[temp.num] = res[temp.num] > res[cur] + require[temp.num] ? res[temp.num]
						: res[cur] + require[temp.num];
				if (--linkCnt[temp.num] == 0) {
					q.offer(temp.num);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append("\n");
		}
	}
}// end of class