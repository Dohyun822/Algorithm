import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int u;
	private static int v;
	private static int[] p;
	private static int[] rank;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if (M == 0) {
			System.out.println(N);
			return;
		}
		p = new int[N + 1];
		rank = new int[N + 1];
		makeSet();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			union(u, v);
		}
		answer = 0;
		for (int i = 1; i <= N; i++) {
			if (p[i] == i) {
				answer++;
			}
		}
		System.out.println(answer);

	}// end of main

	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px != py) {
			link(px, py);
		}
	}

	private static void link(int px, int py) {
		if (rank[px] > rank[py]) {
			p[py] = px;
		} else {
			p[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}

	}

	private static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
}// end of class