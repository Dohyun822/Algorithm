import java.io.*;
import java.util.*;

public class Main {
	private static int M;
	private static int N;
	private static int[][] map;
	private static int[][] count;

	private static int[] dr = { 1, -1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		count = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			Arrays.fill(count[i], Integer.MAX_VALUE);
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs(0, 0);

		System.out.println(count[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { x, y });
		count[x][y] = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dr[i];
				int nextY = curY + dc[i];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					int nextCount = count[curX][curY] + map[nextX][nextY];

					if (nextCount < count[nextX][nextY]) {
						count[nextX][nextY] = nextCount;
						queue.offer(new int[] { nextX, nextY });
					}
				}
			}
		}
	}

}