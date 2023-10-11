import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int area;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];
		count = 0;
		area = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				if (map[i][j] == 1) {
					solve(i, j);
					count++;
				}
			}
		}

		System.out.println(count);
		System.out.println(area);

	}

	private static void solve(int i, int j) {
		Queue<Integer> qr = new ArrayDeque<Integer>();
		Queue<Integer> qc = new ArrayDeque<Integer>();

		qr.offer(i);
		qc.offer(j);
		map[i][j] = 0;
		int countArea = 1;
		while (!qr.isEmpty()) {
			int r = qr.poll();
			int c = qc.poll();
			for (int k = 0; k < dc.length; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == 1) {
					qr.offer(nr);
					qc.offer(nc);
					map[nr][nc] = 0;
					visited[nr][nc] = true;
					countArea++;
				}
			}

		}
		area = area > countArea ? area : countArea;
	}
}
