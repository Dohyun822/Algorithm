import java.io.*;
import java.util.*;

public class Main {
	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dr = { -1, 0, 1 };
	private static int[] dc = { 1, 1, 1 };
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			if (map[i][0] == '.') {
				if (dfs(i, 0)) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	private static boolean dfs(int r, int c) {
		visited[r][c] = true;

		if (c == C - 1) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < R && nc < C && map[nr][nc] == '.' && !visited[nr][nc]) {
				if (dfs(nr, nc)) {
					return true;
				}
			}
		}

		return false;
	}
}
