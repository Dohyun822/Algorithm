import java.io.*;
import java.util.*;

public class Main {
	private static int R;
	private static int C;
	private static char[][] map;
	private static int answer;

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}

		System.out.println(answer);

	}

	private static void bfs(int i, int j) {
		int[][] dist = new int[R][C];
		boolean[][] visited = new boolean[R][C];

		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int k = 0; k < dr.length; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == 'L') {
					dist[nr][nc] = dist[r][c] + 1;
					answer = Math.max(answer, dist[nr][nc]);
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}
}