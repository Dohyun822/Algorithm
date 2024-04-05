import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int n;
	static Map<String, Integer> nameToIndex;
	static Map<Integer, String> indexToName;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		nameToIndex = new HashMap<>();
		indexToName = new HashMap<>();
		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			String kingdom = br.readLine();
			nameToIndex.put(kingdom, i);
			indexToName.put(i, kingdom);
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			String kingdom1Name = st.nextToken();
			String kingdom2Name = st.nextToken();
			int winner = Integer.parseInt(st.nextToken());
			int kingdom1 = nameToIndex.get(kingdom1Name);
			int kingdom2 = nameToIndex.get(kingdom2Name);

			if (winner == 1) {
				if (find(kingdom1) == kingdom2) {
					parent[kingdom1] = kingdom1;
					for (int j = 1; j <= n; j++) {
						if (find(j) == kingdom2) {
							union(kingdom1, j);
						}
					}
				} else {
					union(kingdom1, kingdom2);
				}
			} else {
				if (find(kingdom2) == kingdom1) {
					parent[kingdom2] = kingdom2;
					for (int j = 1; j <= n; j++) {
						if (find(j) == kingdom1) {
							union(kingdom2, j);
						}
					}
				} else {
					union(kingdom2, kingdom1);
				}
			}
		}

		TreeSet<String> Kingdoms = new TreeSet<>();
		for (int i = 1; i <= n; i++) {
			if (find(i) == i) {
				Kingdoms.add(indexToName.get(i));
			}
		}

		System.out.println(Kingdoms.size());
		for (String kingdom : Kingdoms) {
			System.out.println(kingdom);
		}
	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}
}