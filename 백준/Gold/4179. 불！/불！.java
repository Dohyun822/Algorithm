import java.io.*;
import java.util.*;

public class Main {
	private static int[] dr = { 1, -1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int R;
	private static int C;
	private static char[][] map;
	private static int[][] jihun;
	private static int[][] fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		fire = new int[R][C];
		jihun = new int[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		solve();

	}

	private static void solve() {
		Queue<int[]> person = new ArrayDeque<int[]>();
		Queue<int[]> bull = new ArrayDeque<int[]>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				jihun[i][j] = Integer.MAX_VALUE;
				fire[i][j] = Integer.MAX_VALUE;
				if (map[i][j] == 'J') {
					person.offer(new int[] { i, j });
					jihun[i][j] = 0;
				}
				if (map[i][j] == 'F') {
					bull.offer(new int[] { i, j });
					fire[i][j] = 0;
				}
			}
		}

		while (!bull.isEmpty()) {
			int[] cur = bull.poll();
			for (int i = 0; i < dr.length; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '#' && fire[nr][nc] == Integer.MAX_VALUE) {
					fire[nr][nc] = fire[cur[0]][cur[1]] + 1;
					bull.offer(new int[] { nr, nc });
				}
			}
		}
		while (!person.isEmpty()) {
			int[] cur = person.poll();
			if (cur[0] == 0 || cur[1] == 0 || cur[0] == R - 1 || cur[1] == C - 1) {
				System.out.println(jihun[cur[0]][cur[1]] + 1);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.' && jihun[nr][nc] == Integer.MAX_VALUE
						&& (jihun[cur[0]][cur[1]] + 1 < fire[nr][nc])) {
					jihun[nr][nc] = jihun[cur[0]][cur[1]] + 1;
					person.offer(new int[] { nr, nc });

				}
			}
		}

		System.out.println("IMPOSSIBLE");

	}
}