import java.io.*;
import java.util.*;

public class Main {
	private static int[][] map;
	private static boolean[][] visited;
	private static int count;
	private static int area;

	private static int[] dr = { 1, -1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int n;
	private static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = 0;
		area = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					solve(i, j);
					count++;
				}
			}
		}

		System.out.println(count);
		System.out.println(area);

	}

	private static void solve(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();

		q.offer(new int[] { i, j });
		visited[i][j] = true;

		int maxArea = 1;

		while (!q.isEmpty()) {
			int[] point = q.poll();
			int r = point[0];
			int c = point[1];

			for (int k = 0; k < dr.length; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == 1) {
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
					maxArea++;
				}
			}
		}

		area = Math.max(area, maxArea);
	}
}