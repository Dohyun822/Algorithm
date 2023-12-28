import java.io.*;
import java.util.*;

public class Main {
	public static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		public int compareTo(Edge o) {
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

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Edge> arr = new ArrayList<Edge>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());

			arr.add(new Edge(A, B, C));
		}

		Collections.sort(arr);
		int answer = 0;
		int max = 0;

		UnionFind uf = new UnionFind(N);

		for (Edge edge : arr) {
			int x = uf.find(edge.src);
			int y = uf.find(edge.dest);

			if (x != y) {
				answer += edge.weight;
				uf.union(x, y);
				max = Math.max(max, edge.weight);
			}
		}

		System.out.println(answer - max);
	}

}