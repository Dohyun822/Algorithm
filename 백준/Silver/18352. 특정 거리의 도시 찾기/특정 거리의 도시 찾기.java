import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
		}

		int[] distance = new int[N + 1];
		Arrays.fill(distance, -1);
		distance[X] = 0;

		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(X);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : graph[current]) {
				if (distance[next] == -1) {
					distance[next] = distance[current] + 1;
					queue.offer(next);
				}
			}
		}

		boolean exists = false;
		for (int i = 1; i <= N; i++) {
			if (distance[i] == K) {
				System.out.println(i);
				exists = true;
			}
		}

		if (!exists) {
			System.out.println(-1);
		}
	}
}
