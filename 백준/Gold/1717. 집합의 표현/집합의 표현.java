import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (command == 0) {
				union(a, b);
			} else {
				int rootX = find(a);
				int rootY = find(b);
				if (rootX != rootY) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}
		}

	}

	private static void union(int a, int b) {
		int rootX = find(a);
		int rootY = find(b);

		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}

	private static int find(int a) {
		if (parent[a] != a) {
			parent[a] = find(parent[a]);
		}
		return parent[a];
	}
}
