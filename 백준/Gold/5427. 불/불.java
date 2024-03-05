import java.io.*;
import java.util.*;

public class Main {
	private static int[] dr = { 1, -1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int w;
	private static int h;
	private static char[][] map;
	private static int[][] sang;
	private static int[][] fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new char[h][w];
			sang = new int[h][w];
			fire = new int[h][w];

			for (int j = 0; j < h; j++) {
				String s = br.readLine();
				for (int k = 0; k < w; k++) {
					map[j][k] = s.charAt(k);
				}
			}

			solve();
		}

	}

	private static void solve() {
		Queue<int[]> start = new ArrayDeque<int[]>();
		Queue<int[]> bull = new ArrayDeque<int[]>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				sang[i][j] = Integer.MAX_VALUE;
				fire[i][j] = Integer.MAX_VALUE;
				if (map[i][j] == '@') {
					start.offer(new int[] { i, j });
					sang[i][j] = 0;
				}
				if (map[i][j] == '*') {
					bull.offer(new int[] { i, j });
					fire[i][j] = 0;
				}
			}
		}

		while (!bull.isEmpty()) {
			int[] cur = bull.poll();
			int r = cur[0];
			int c = cur[1];
			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && fire[nr][nc] == Integer.MAX_VALUE && map[nr][nc] == '.') {
					fire[nr][nc] = fire[r][c] + 1;
					bull.offer(new int[] { nr, nc });
				}
			}
		}

		while (!start.isEmpty()) {
			int[] cur = start.poll();
			int r = cur[0];
			int c = cur[1];
			if (r == 0 || c == 0 || r == h - 1 || c == w - 1) {
				System.out.println(sang[r][c] + 1);
				return;
			}
			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == '.' && sang[r][c] + 1 < fire[nr][nc]
						&& sang[nr][nc] == Integer.MAX_VALUE) {
					sang[nr][nc] = sang[r][c] + 1;
					start.offer(new int[] { nr, nc });
				}
			}
		}

		System.out.println("IMPOSSIBLE");

	}
}