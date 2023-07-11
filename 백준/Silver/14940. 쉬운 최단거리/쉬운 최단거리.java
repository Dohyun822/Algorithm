import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map, dist;
	static int[] dr = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	static int[] dc = { 0, 1, 0, -1 };
	static Point target;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					target = new Point(i, j);
				}
				dist[i][j] = map[i][j] == 0 ? 0 : -1;
			}
		}

		bfs();

		StringBuilder sb = new StringBuilder();
		for (int[] row : dist) {
			for (int element : row) {
				sb.append(element == -1 ? -1 : element).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

	public static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(target);
		dist[target.r][target.c] = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 0 || dist[nr][nc] != -1) {
					continue;
				}

				dist[nr][nc] = dist[cur.r][cur.c] + 1;
				q.offer(new Point(nr, nc));
			}
		}
	}
}