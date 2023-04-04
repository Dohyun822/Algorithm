import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R;
	private static int C;
	private static int[][] map;
	private static int cnt;
	private static int time;
	private static int preCnt;
	private static int[][] copyMap;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		copyMap = new int[R][C];

		cnt = 0;
		time = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int x = Integer.parseInt(st.nextToken());
				map[i][j] = x;
				copyMap[i][j] = x;
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}

		preCnt = cnt;
		while (cnt != 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {
						chk(i, j);
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = copyMap[i][j];
				}
			}
			if (cnt > 0) {
				preCnt = cnt;
			}
			time++;
		}

		sb.append(time).append("\n").append(preCnt);
		System.out.println(sb.toString());

	}

	private static void chk(int i, int j) {
		for (int k = 0; k < dr.length; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			if (map[nr][nc] == 0) {
				if (bfs(nr, nc)) {
					copyMap[i][j] = 0;
					cnt--;
					break;
				}

			}
		}
	}

	private static boolean bfs(int nr, int nc) {
		if (nr == 0 || nr == R - 1 || nc == 0 || nc == C - 1) {
			return true;
		}
		visited = new boolean[R][C];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(nr);
		q.offer(nc);
		visited[nr][nc] = true;

		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();

			for (int i = 0; i < dr.length; i++) {
				int rr = r + dr[i];
				int cc = c + dc[i];
				if (rr == 0 || rr == R - 1 || cc == 0 || cc == C - 1) {
					return true;
				} else if (map[rr][cc] == 0 && !visited[rr][cc]) {
					q.offer(rr);
					q.offer(cc);
					visited[rr][cc] = true;
				}
			}
		}
		return false;
	}
}