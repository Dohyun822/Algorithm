import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static char[][] map;
	private static int nomal;
	private static int redgreen;
	private static boolean[][] visited;
	private static boolean[][] visited2;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		nomal = 0;
		redgreen = 0;

		solve();
		System.out.println(nomal + " " + redgreen);
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					nomal++;
				}
				if (!visited2[i][j]) {
					dfs2(i, j);
					redgreen++;
				}
			}
		}
	}

	private static void dfs2(int i, int j) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(i);
		s.push(j);
		visited2[i][j] = true;

		while (!s.isEmpty()) {
			int curC = s.pop();
			int curR = s.pop();
			char temp = map[curR][curC];
			for (int k = 0; k < dr.length; k++) {
				int nr = curR + dr[k];
				int nc = curC + dc[k];
				if (temp == 'B') {
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited2[nr][nc] && map[nr][nc] == temp) {
						s.push(nr);
						s.push(nc);
						visited2[nr][nc] = true;
					}
				} else {
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited2[nr][nc]
							&& (map[nr][nc] == 'R' || map[nr][nc] == 'G')) {
						s.push(nr);
						s.push(nc);
						visited2[nr][nc] = true;
					}
				}
			}
		}

	}

	private static void dfs(int i, int j) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(i);
		s.push(j);
		visited[i][j] = true;

		while (!s.isEmpty()) {
			int curC = s.pop();
			int curR = s.pop();
			char temp = map[curR][curC];
			for (int k = 0; k < dr.length; k++) {
				int nr = curR + dr[k];
				int nc = curC + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == temp) {
					s.push(nr);
					s.push(nc);
					visited[nr][nc] = true;
				}
			}
		}
	}
}// end of class