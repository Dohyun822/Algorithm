import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[][] map;
	private static int len;
	private static int[][] copyMap;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static boolean[][] visited;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		len = N * M;

		map = new int[N][M];
		copyMap = new int[N][M];
		answer = 0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i == j)
					continue;
				for (int k = 0; k < len; k++) {
					if (k == i || k == j)
						continue;
					if (chk(i, j, k)) {
						makeCopyMap();
						solve(i, j, k);
					}

				}
			}
		}
		System.out.println(answer);

	}

	private static void makeCopyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	private static void solve(int i, int j, int k) {
		copyMap[i / M][i % M] = 1;
		copyMap[j / M][j % M] = 1;
		copyMap[k / M][k % M] = 1;

		bfs();
	}

	private static void bfs() {
		visited = new boolean[N][M];
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 2 && !visited[i][j]) {
					q.offer(i);
					q.offer(j);
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int r = q.poll();
						int c = q.poll();
						for (int k = 0; k < dr.length; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && copyMap[nr][nc] == 0) {
								copyMap[nr][nc] = 2;
								q.offer(nr);
								q.offer(nc);
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}

		countAnswer();
	}

	private static void countAnswer() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		answer = cnt > answer ? cnt : answer;
	}

	private static boolean chk(int i, int j, int k) {
		if (map[i / M][i % M] != 0 || map[j / M][j % M] != 0 || map[k / M][k % M] != 0) {
			return false;
		}
		return true;
	}
}// end of class