import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int connect = Integer.parseInt(st.nextToken());
				if (connect == 1) {
					union(i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int[] plan = new int[M];
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

		boolean chk = true;
		int root = find(plan[0]);
		for (int i = 1; i < M; i++) {
			if (find(plan[i]) != root) {
				chk = false;
				break;
			}
		}

		if (chk) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}

	private static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
}