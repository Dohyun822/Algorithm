import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static boolean[][] visited;
	private static int[][] map;

	private static int[] dr = { 1, -1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = (s.charAt(j) - '0');
			}
		}

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}

		System.out.println(cnt);

		Collections.sort(list);

		for (Integer x : list) {
			System.out.println(x);
		}
	}

	private static void dfs(int i, int j) {
		Stack<int[]> stack = new Stack<int[]>();
		stack.push(new int[] { i, j });
		visited[i][j] = true;

		int cnt = 1;
		while (!stack.isEmpty()) {
			int[] cur = stack.pop();
			int r = cur[0];
			int c = cur[1];
			for (int k = 0; k < dc.length; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					stack.push(new int[] { nr, nc });
					cnt++;
				}
			}
		}
		list.add(cnt);

	}

}