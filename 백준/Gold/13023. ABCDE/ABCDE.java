import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static int chk;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());

			arr[p1].add(p2);
			arr[p2].add(p1);
		}
		for (int i = 0; i < N; i++) {
			chk = 0;
			dfs(i, new boolean[N], 0);
			if (chk == 1) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);

	}// end of main

	private static void dfs(int current, boolean[] visited, int cnt) {
		visited[current] = true;

//		System.out.println(current);
		if (cnt == 4) {
			chk = 1;
			return;
		}

		for (int vertex : arr[current]) {
			if (!visited[vertex]) {
				visited[vertex] = true;
				dfs(vertex, visited, cnt + 1);
				visited[vertex] = false;
			}
		}

	}
}// end of class