import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int V;
	static ArrayList<Integer>[] graph;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
			graph[to].add(from);
		}
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph[i]);
		}
		dfs(V, new boolean[N + 1]);
		sb.append("\n");
		bfs(V);

		System.out.print(sb.toString());
	}// end of main

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N + 1];
		q.offer(start);
		visited[start] = true;

		int current = 0;
		while (!q.isEmpty()) {
			current = q.poll();
			sb.append(current).append(" ");

			for (int vertex : graph[current]) {
				if (!visited[vertex]) {
					q.offer(vertex);
					visited[vertex] = true;
				}
			}
		}
	}

	private static void dfs(int start, boolean[] visited) {
		visited[start] = true;
		sb.append(start).append(" ");

		for (int vertex : graph[start]) {
			if (!visited[vertex]) {
				dfs(vertex, visited);
			}
		}

	}
}// end of class