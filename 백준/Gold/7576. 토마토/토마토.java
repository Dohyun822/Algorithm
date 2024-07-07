import java.io.*;
import java.util.*;

public class Main {
	private static int M;
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static Queue<int[]> q;

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		q = new ArrayDeque<int[]>();

		cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int info = Integer.parseInt(st.nextToken());
				map[i][j] = info;
				if (info == 1) {
					q.offer(new int[] { i, j });
					visited[i][j] = true;
				} else if (info == 0) {
					cnt++;
				}
			}
		}

		System.out.println(bfs());

	}

	private static int bfs() {
		int day = -1;
		while (!q.isEmpty()) {
			day++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				for (int k = 0; k < dr.length; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 0) {
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc });
						cnt--;
					}
				}
			}
		}

		return cnt == 0 ? day : -1;
	}
}
