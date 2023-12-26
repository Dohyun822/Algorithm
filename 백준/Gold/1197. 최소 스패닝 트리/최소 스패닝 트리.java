import java.io.*;
import java.util.*;

public class Main {
	public static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;

		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static class UnionFind {
		private int[] parent;

		public UnionFind(int size) {
			parent = new int[size];
			for (int i = 0; i < size; i++) {
				parent[i] = i;
			}
		}

		public int find(int x) {
			if (parent[x] == x) {
				return x;
			}
			return parent[x] = find(parent[x]);
		}

		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX != rootY) {
				parent[rootY] = rootX;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<Edge> edges = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			edges.add(new Edge(src, dest, weight));
		}

		Collections.sort(edges);

		UnionFind uf = new UnionFind(V);
		int mstWeight = 0;

		for (Edge edge : edges) {
			int x = uf.find(edge.src);
			int y = uf.find(edge.dest);

			if (x != y) {
				uf.union(x, y);
				mstWeight += edge.weight;
			}
		}

		System.out.println(mstWeight);
	}

}