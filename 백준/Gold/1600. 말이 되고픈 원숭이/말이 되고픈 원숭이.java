import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int K;
	private static int W;
	private static int H;
	private static int[][] map;

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int[] kr = { -2, -2, -1, 1, 2, 2, -1, 1 };
	private static int[] kc = { -1, 1, 2, 2, -1, 1, -2, -2 };
	private static boolean[][][] visited;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? 9999999 : 0;
			}
		}

		answer = solve(0, 0, K, 0);
		if (answer == 9999999) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}// end of main

	private static int solve(int r, int c, int k, int cnt) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(r);
		q.offer(c);
		q.offer(k);
		q.offer(cnt);
		visited[r][c][k] = true;

		while (!q.isEmpty()) {
			int currentR = q.poll();
			int currentC = q.poll();
			int currentK = q.poll();
			int currentCnt = q.poll();
			if ((currentR == H - 1 && currentC == W - 1)) {
				return currentCnt;
			}

			for (int i = 0; i < dr.length; i++) {
				int nr = currentR + dr[i];
				int nc = currentC + dc[i];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc][currentK] && map[nr][nc] == 0) {
					q.offer(nr);
					q.offer(nc);
					q.offer(currentK);
					q.offer(currentCnt + 1);
					visited[nr][nc][currentK] = true;
				}
			}

			if (currentK > 0) {
				for (int i = 0; i < kr.length; i++) {
					int nr = currentR + kr[i];
					int nc = currentC + kc[i];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc][currentK - 1] && map[nr][nc] == 0) {
						q.offer(nr);
						q.offer(nc);
						q.offer(currentK - 1);
						q.offer(currentCnt + 1);
						visited[nr][nc][currentK-1] = true;
					}
				}
			}

		}

		return 9999999;
	}
}// end of class