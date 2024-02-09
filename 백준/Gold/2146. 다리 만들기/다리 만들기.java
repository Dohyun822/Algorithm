import java.io.*;
import java.util.*;

public class Main {
	private static int[][] map;
	private static int[][] part;
	private static int[] dr = { 1, -1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		part = new int[N][N];
		int partNumber = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (part[i][j] == 0 && map[i][j] == 1) {
					partNumber++;
					bfs(i, j, partNumber);
				}
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 1; i <= partNumber; i++) {
			answer = Math.min(answer, solve(i));
		}

		System.out.println(answer);

	}

	private static int solve(int i) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][N];

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				if (part[j][k] == i) {
					queue.add(new int[] { j, k, 0 });
					visited[j][k] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int j = 0; j < 4; j++) {
				int nr = cur[0] + dr[j];
				int nc = cur[1] + dc[j];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					if (map[nr][nc] == 1 && part[nr][nc] != i) {
						return cur[2];
					}
					if (map[nr][nc] == 0) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc, cur[2] + 1 });
					}
				}
			}
		}
		return 0;
	}

	private static void bfs(int i, int j, int partNumber) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { i, j });
		part[i][j] = partNumber;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + dr[k];
				int nc = cur[1] + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && part[nr][nc] == 0) {
					part[nr][nc] = partNumber;
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}

}