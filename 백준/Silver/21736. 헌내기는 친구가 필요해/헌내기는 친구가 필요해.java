import java.io.*;
import java.util.*;

public class Main {

	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int startR;
	private static int startC;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		startR = 0;
		startC = 0;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if (c == 'X')
					map[i][j] = -1;
				else if (c == 'I') {
					map[i][j] = 0;
					startR = i;
					startC = j;
				} else if(c == 'P') {
					map[i][j] = 1;
				}
			}
		}

		int answer = bfs(startR, startC);

		if (answer == 0) {
			System.out.println("TT");
		} else {
			System.out.println(answer);
		}

	}

	private static int bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c, });

		int count = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (!visited[nr][nc] && map[nr][nc] != -1) {
						visited[nr][nc] = true;
						queue.offer(new int[] { nr, nc });
						if (map[nr][nc] == 1) {
							count++;
						}
					}
				}

			}
		}
		return count;
	}
}
