import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num;
		int cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

	}

	private static int N;
	private static int M;
	private static int[] answer;
	private static boolean[] chk;
	private static int X;
	private static int Y;
	private static int K;
	private static ArrayList<Node>[] memo;
	private static int[] linkCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		linkCnt = new int[N + 1];
		chk = new boolean[N + 1];
		memo = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			memo[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			memo[X].add(new Node(Y, K));
			chk[X] = true;
			linkCnt[Y]++;
		}

		solve();

		for (int i = 1; i < N; i++) {
			if (!chk[i]) {
				sb.append(i).append(" ").append(answer[i]).append("\n");
			}
		}

		System.out.print(sb.toString());

	}// end of main

	private static void solve() {
		answer = new int[N + 1];
		Queue<Node> q = new ArrayDeque<Node>();

		q.offer(new Node(N, 1));
		answer[N] = 1;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < memo[cur.num].size(); i++) {
				Node temp = memo[cur.num].get(i);
				answer[temp.num] += answer[cur.num] * temp.cnt;
				if (--linkCnt[temp.num] == 0) {
					q.offer(new Node(temp.num, answer[temp.num]));
				}
			}

		}

	}
}// end of class