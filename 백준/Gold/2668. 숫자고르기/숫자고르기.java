import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[] graph;
	private static ArrayList<Integer> list;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = new int[N + 1];
		list = new ArrayList<Integer>();
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			solve(i, i);
			visited[i] = false;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int x : list) {
			System.out.println(x);
		}

	}

	private static void solve(int start, int target) {
		if (visited[graph[start]] == false) {
			visited[graph[start]] = true;
			solve(graph[start], target);
			visited[graph[start]] = false;
		}
		if (graph[start] == target) {
			list.add(target);
		}
	}

}