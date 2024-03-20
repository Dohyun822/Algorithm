import java.io.*;
import java.util.*;

public class Main {
	private static int w;
	private static int h;
	private static int[] dr = { -1, -1, -1, 1, 1, 1, 0, 0 };
	private static int[] dc = { 0, -1, 1, 0, -1, 1, -1, 1 };
	private static int[][] map;
	private static boolean[][] visited;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];

			answer = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						solve(i, j);
						answer++;
					}
				}
			}

			System.out.println(answer);

		}

	}

	private static void solve(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();

		q.offer(new int[] { i, j });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < dr.length; k++) {
				int nr = cur[0] + dr[k];
				int nc = cur[1] + dc[k];
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}

	}
}