import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] visited;

	private static int[] dr = { 1, -1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		boolean check = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					check = false;
				}
			}
		}

		if (check) {
			System.out.println(0);
			return;
		}

		answer = 0;

		solve();

		System.out.println(answer);

	}

	private static void solve() {
		Queue<int[]> q = new ArrayDeque<int[]>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					visited[i][j] = true;
					q.offer(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] point = q.poll();
				int r = point[0];
				int c = point[1];
				for (int j = 0; j < dr.length; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 0) {
						map[nr][nc] = 1;
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					}
				}
			}
			if (!q.isEmpty()) {
				answer++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					answer = -1;
					return;
				}
			}
		}

	}
}