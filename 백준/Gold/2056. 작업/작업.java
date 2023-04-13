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
	private static Node[] work;
	private static int[] linkCnt;
	private static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		work = new Node[N + 1];
		require = new int[N + 1];
		linkCnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			require[i] = Integer.parseInt(st.nextToken());

			int cnt = Integer.parseInt(st.nextToken());

			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				work[i] = new Node(num, work[i]);
				linkCnt[num]++;
			}
		}

		solve();
	}

	private static void solve() {
		answer = new int[N + 1];
		Queue<Integer> q = new ArrayDeque<Integer>();

		for (int i = 1; i <= N; i++) {
			answer[i] = require[i];
			if (linkCnt[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Node temp = work[cur]; temp != null; temp = temp.link) {
				answer[temp.num] = answer[temp.num] > answer[cur] + require[temp.num] ? answer[temp.num]
						: answer[cur] + require[temp.num];
				if (--linkCnt[temp.num] == 0) {
					q.offer(temp.num);
				}
			}
		}

		int res = 0;
		for (int x : answer) {
			res = Math.max(res, x);
		}
		System.out.println(res);
	}
}