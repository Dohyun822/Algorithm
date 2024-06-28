import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		int time = 0;

		while (true) {
			findAir();

			List<int[]> cheese = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1 && chk(i, j)) {
						cheese.add(new int[] { i, j });
					}
				}
			}

			if (cheese.isEmpty()) {
				break;
			}

			for (int[] cur : cheese) {
				arr[cur[0]][cur[1]] = 0;
			}

			time++;
		}

		return time;
	}

	private static void findAir() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && arr[nr][nc] == 0) {
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static boolean chk(int r, int c) {
		int side = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc]) {
				side++;
			}
		}
		return side >= 2;
	}
}