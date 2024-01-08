import java.io.*;
import java.util.*;

class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	private static int R;
	private static int C;
	private static char[][] map;
	private static int[][] fireTime;
	private static int[][] jihunTime;
	private static Queue<int[]> fireQueue = new ArrayDeque<>();
	private static Queue<int[]> jihunQueue = new ArrayDeque<>();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		fireTime = new int[R][C];
		jihunTime = new int[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				fireTime[i][j] = -1;
				jihunTime[i][j] = -1;
				if (map[i][j] == 'F') {
					fireQueue.offer(new int[] { i, j });
					fireTime[i][j] = 0;
				}
				if (map[i][j] == 'J') {
					jihunQueue.offer(new int[] { i, j });
					jihunTime[i][j] = 0;
				}
			}
		}

		fire();

		int answer = jihun();

		if (answer == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(answer);
		}
	}

	private static void fire() {
		while (!fireQueue.isEmpty()) {
			int[] cur = fireQueue.poll();
			int r = cur[0];
			int c = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (map[nr][nc] == '.' && fireTime[nr][nc] == -1) {
						fireTime[nr][nc] = fireTime[r][c] + 1;
						fireQueue.offer(new int[] { nr, nc });
					}
				}
			}
		}
	}

	private static int jihun() {
		while (!jihunQueue.isEmpty()) {
			int[] cur = jihunQueue.poll();
			int r = cur[0];
			int c = cur[1];

			if (r == 0 || c == 0 || r == R - 1 || c == C - 1) {
				return jihunTime[r][c] + 1;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (map[nr][nc] == '.' && jihunTime[nr][nc] == -1) {
						if (fireTime[nr][nc] == -1 || jihunTime[r][c] + 1 < fireTime[nr][nc]) {
							jihunTime[nr][nc] = jihunTime[r][c] + 1;
							jihunQueue.offer(new int[] { nr, nc });
						}
					}
				}
			}
		}
		return -1;
	}
}
