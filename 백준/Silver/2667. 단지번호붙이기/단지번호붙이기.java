import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] map;
	private static ArrayList<Integer> list;
	private static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		list = new ArrayList<Integer>();
		visited = new boolean[N][N];

		solve();

		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (Integer x : list) {
			sb.append(x).append("\n");
		}
		System.out.println(sb.toString());

	}// end of main

	private static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					if (map[i][j] == 1) {
						dfs(i, j);
					}
				}
			}
		}
	}

	private static void dfs(int r, int c) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(r);
		stack.push(c);

		int cnt = 1;
		while (!stack.isEmpty()) {
			int curC = stack.pop();
			int curR = stack.pop();
			for (int i = 0; i < dr.length; i++) {
				int nr = curR + dr[i];
				int nc = curC + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					stack.push(nr);
					stack.push(nc);
					cnt++;
				}
			}
		}
		list.add(cnt);
	}
}// end of class