import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static int[] distance;
	private static int n;
	private static int personA;
	private static int personB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		personA = Integer.parseInt(st.nextToken());
		personB = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			graph[parent].add(child);
			graph[child].add(parent);
		}

		visited = new boolean[n + 1];
		distance = new int[n + 1];
		Arrays.fill(distance, -1);

		dfs(personA, 0);

		System.out.println(distance[personB]);
	}

	static void dfs(int current, int dist) {
		visited[current] = true;
		distance[current] = dist;

		for (int next : graph[current]) {
			if (!visited[next]) {
				dfs(next, dist + 1);
			}
		}
	}
}
