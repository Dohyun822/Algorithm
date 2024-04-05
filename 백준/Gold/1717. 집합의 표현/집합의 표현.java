import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] parent;
	private static int[] rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int operation = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (operation == 0) {
				union(a, b);
			} else if (operation == 1) {
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB) {
			if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
			} else if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
			} else {
				parent[rootB] = rootA;
				rank[rootA]++;
			}
		}
	}
}