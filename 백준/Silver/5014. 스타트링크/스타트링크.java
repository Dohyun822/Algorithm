import java.io.*;
import java.util.*;

public class Main {
	private static int F;
	private static int S;
	private static int G;
	private static int U;
	private static int D;
	private static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		F = Integer.parseInt(st.nextToken()); // 총 F층
		S = Integer.parseInt(st.nextToken()); // 현재 층
		G = Integer.parseInt(st.nextToken()); // 목표 G층
		U = Integer.parseInt(st.nextToken()); // 위로 U층
		D = Integer.parseInt(st.nextToken()); // 아래로 D층

		visited = new int[F + 1];
		Arrays.fill(visited, -1);

		solve();
	}

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(S);
		visited[S] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == G) {
				System.out.println(visited[cur]);
				return;
			}

			int[] next = { cur + U, cur - D };
			for (int x : next) {
				if (x >= 1 && x <= F && visited[x] == -1) {
					visited[x] = visited[cur] + 1;
					q.offer(x);
				}
			}
		}
		System.out.println("use the stairs");
	}
}