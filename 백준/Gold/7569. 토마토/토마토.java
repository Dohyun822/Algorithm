import java.io.*;
import java.util.*;

public class Main {
	private static int M;
	private static int N;
	private static int H;
	private static int[][][] tomato;
	private static boolean[][][] visited;

	private static int[] dr = { 1, -1, 0, 0, 0, 0 };
	private static int[] dc = { 0, 0, 1, -1, 0, 0 };
	private static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tomato = new int[H][N][M];
		visited = new boolean[H][N][M];
		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if (tomato[i][j][k] == 1) {
						queue.offer(new int[] { i, j, k });
						visited[i][j][k] = true;
					}
				}
			}
		}

		int answer = bfs(queue);

		if (chk()) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean chk() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tomato[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static int bfs(Queue<int[]> queue) {
		int day = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			day++;
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();
				int z = current[0];
				int y = current[1];
				int x = current[2];

				for (int d = 0; d < 6; d++) {
					int nz = z + dz[d];
					int nr = y + dr[d];
					int nc = x + dc[d];

					if (nz >= 0 && nz < H && nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nz][nr][nc]
							&& tomato[nz][nr][nc] == 0) {
						tomato[nz][nr][nc] = 1;
						visited[nz][nr][nc] = true;
						queue.offer(new int[] { nz, nr, nc });
					}
				}
			}
		}

		return day;
	}
}
