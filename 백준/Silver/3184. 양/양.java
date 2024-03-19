import java.io.*;
import java.util.*;

public class Main {
	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[][] visited;
	private static int o;
	private static int v;

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		o = 0;
		v = 0;

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char temp = s.charAt(j);
				if (temp == 'o') {
					o++;
				} else if (temp == 'v') {
					v++;
				}
				map[i][j] = temp;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(o + " " + v);

	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();

		q.offer(new int[] { i, j });
		visited[i][j] = true;

		int sheep = 0;
		int wolf = 0;

		if (map[i][j] == 'o') {
			sheep++;
		} else if (map[i][j] == 'v') {
			wolf++;
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + dr[k];
				int nc = cur[1] + dc[k];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '#' && !visited[nr][nc]) {
					if (map[nr][nc] == 'o') {
						sheep++;
					} else if (map[nr][nc] == 'v') {
						wolf++;
					}
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}

		if (sheep > wolf) {
			v -= wolf;
		} else if (sheep <= wolf) {
			o -= sheep;
		}

	}
}