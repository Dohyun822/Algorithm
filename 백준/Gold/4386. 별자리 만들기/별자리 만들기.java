import java.io.*;
import java.util.*;

public class Main {
	public static class Star {
		double x;
		double y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Edge implements Comparable<Edge> {
		int src;
		int desc;
		double weight;

		public Edge(int src, int desc, double weight) {
			this.src = src;
			this.desc = desc;
			this.weight = weight;
		}

		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
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

		int n = Integer.parseInt(br.readLine());

		Star[] arr = new Star[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			arr[i] = new Star(x, y);
		}

		ArrayList<Edge> list = new ArrayList<Edge>();

		for (int i = 0; i < n; i++) {
			Star src = arr[i];
			for (int j = i + 1; j < n; j++) {
				Star dest = arr[j];
				double weight = getWeight(src, dest);
				list.add(new Edge(i, j, weight));
			}
		}

		Collections.sort(list);

		UnionFind uf = new UnionFind(n);
		double answer = 0;

		for (Edge edge : list) {
			int x = uf.find(edge.src);
			int y = uf.find(edge.desc);

			if (x != y) {
				answer += edge.weight;
				uf.union(x, y);
			}
		}

		System.out.println(answer);

	}

	private static double getWeight(Star src, Star dest) {
		double x1 = src.x;
		double y1 = src.y;
		double x2 = dest.x;
		double y2 = dest.y;

		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

}