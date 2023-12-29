import java.util.*;
import java.io.*;

public class Main {
	public static class Edge implements Comparable<Edge> {
		int src;
		int desc;
		int weight;

		public Edge(int src, int desc, int weight) {
			this.src = src;
			this.desc = desc;
			this.weight = weight;
		}

		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static class Planet {
		int num;
		int x;
		int y;
		int z;

		public Planet(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
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

	private static Planet[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new Planet[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arr[i] = new Planet(i, x, y, z);
		}

		ArrayList<Edge> edges = new ArrayList<Edge>();

		Arrays.sort(arr, (a, b) -> a.x - b.x);
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(arr[i].num, arr[i + 1].num, Math.abs(arr[i].x - arr[i + 1].x)));
		}
		Arrays.sort(arr, (a, b) -> a.y - b.y);
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(arr[i].num, arr[i + 1].num, Math.abs(arr[i].y - arr[i + 1].y)));
		}
		Arrays.sort(arr, (a, b) -> a.z - b.z);
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(arr[i].num, arr[i + 1].num, Math.abs(arr[i].z - arr[i + 1].z)));
		}

		Collections.sort(edges);
		UnionFind uf = new UnionFind(N);

		int answer = 0;
		for (Edge edge : edges) {
			if (uf.find(edge.src) != uf.find(edge.desc)) {
				uf.union(edge.src, edge.desc);
				answer += edge.weight;
			}
		}

		System.out.println(answer);
	}
}