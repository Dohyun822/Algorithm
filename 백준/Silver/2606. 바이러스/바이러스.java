import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] p;
	private static int answer;
	private static int[] rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		answer = 0;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		p = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			makeset(i);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int res = findSet(1);
		for (int i = 2; i <= N; i++) {
			if (findSet(i) == res) {
				answer++;
			}
		}

		System.out.println(answer);

	}// end of main

	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px != py) {
			p[py] = px;
		}
	}

	private static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	private static void makeset(int i) {
		p[i] = i;
	}

}// end of class