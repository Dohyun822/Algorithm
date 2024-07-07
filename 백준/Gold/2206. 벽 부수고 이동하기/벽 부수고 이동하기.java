import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][][] visited;

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2];

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
			}
		}

		System.out.println(bfs());

	}

	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { 1, 1, 0, 1 });
		visited[1][1][0] = true;

		while (!q.isEmpty()) {
			int[] current = q.poll();

			int r = current[0];
			int c = current[1];
			int wall = current[2];
			int dist = current[3];

			if (r == N && c == M) {
				return dist;
			}

			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 1 || nr > N || nc < 1 || nc > M) {
					continue;
				}

				if (map[nr][nc] == 0 && !visited[nr][nc][wall]) {
					visited[nr][nc][wall] = true;
					q.offer(new int[] { nr, nc, wall, dist + 1 });

				}

				if (map[nr][nc] == 1 && wall == 0 && !visited[nr][nc][1]) {
					visited[nr][nc][1] = true;
					q.offer(new int[] { nr, nc, 1, dist + 1 });

				}

			}

		}
		return -1;
	}
}