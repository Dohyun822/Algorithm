import java.io.*;
import java.util.*;

public class Main {

	private static int M;
	private static int N;
	private static int[][] map;
	private static boolean[][][] visited;

	private static int[] dr = { 0, 0, 1, -1 };
	private static int[] dc = { 1, -1, 0, 0 };
	private static int startR;
	private static int startC;
	private static int startD;
	private static int endR;
	private static int endC;
	private static int endD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M + 1][N + 1];
		visited = new boolean[M + 1][N + 1][4];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
		startD = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine(), " ");
		endR = Integer.parseInt(st.nextToken());
		endC = Integer.parseInt(st.nextToken());
		endD = Integer.parseInt(st.nextToken()) - 1;

		System.out.println(bfs());

	}

	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { startR, startC, startD, 0 });
		visited[startR][startC][startD] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int dir = cur[2];
			int dist = cur[3];

			if (r == endR && c == endC && dir == endD) {
				return dist;
			}

			for (int k = 1; k <= 3; k++) {
				int nr = r + (dr[dir] * k);
				int nc = c + (dc[dir] * k);

				if (nr < 1 || nr > M || nc < 1 || nc > N || map[nr][nc] == 1) {
					break;
				}

				if (!visited[nr][nc][dir]) {
					visited[nr][nc][dir] = true;
					q.offer(new int[] { nr, nc, dir, dist + 1 });
				}
			}

			int leftD = 0;
			int rightD = 0;
			switch (dir) {
			case 0:
				leftD = 3;
				rightD = 2;
				break;
			case 1:
				leftD = 2;
				rightD = 3;
				break;
			case 2:
				leftD = 0;
				rightD = 1;
				break;
			case 3:
				leftD = 1;
				rightD = 0;
				break;
			}
			if (!visited[r][c][leftD]) {
				visited[r][c][leftD] = true;
				q.offer(new int[] { r, c, leftD, dist + 1 });

			}

			if (!visited[r][c][rightD]) {
				visited[r][c][rightD] = true;
				q.offer(new int[] { r, c, rightD, dist + 1 });
			}

		}
		return -1;

	}
}