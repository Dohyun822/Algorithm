import java.io.*;
import java.util.*;

public class Main {
	private static int L;
	private static int R;
	private static int C;
	private static char[][][] map;
	private static boolean[][][] visited;
	private static int[] start;
	private static int[] end;
	private static int[][][] result;

	private static int[] dr = new int[] { -1, 1, 0, 0 };
	private static int[] dc = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			result = new int[L][R][C];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String s = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = s.charAt(k);
						if (map[i][j][k] == 'S') {
							start = new int[] { i, j, k };
						}
						if (map[i][j][k] == 'E') {
							end = new int[] { i, j, k };
						}
					}
				}
				br.readLine();
			}

			bfs(start);

			if (!visited[end[0]][end[1]][end[2]]) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped" + " " + "in" + " " + result[end[0]][end[1]][end[2]] + " " + "minute(s).");
			}
		}

	}

	private static void bfs(int[] start) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { start[0], start[1], start[2] });
		visited[start[0]][start[1]][start[2]] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int floor = cur[0];
			int curR = cur[1];
			int curC = cur[2];
			if (floor - 1 >= 0 && !visited[floor - 1][curR][curC] && map[floor - 1][curR][curC] != '#') {
				visited[floor - 1][curR][curC] = true;
				result[floor - 1][curR][curC] = result[floor][curR][curC] + 1;
				q.offer(new int[] { floor - 1, curR, curC });
			}
			if (floor + 1 < L && !visited[floor + 1][curR][curC] && map[floor + 1][curR][curC] != '#') {
				visited[floor + 1][curR][curC] = true;
				result[floor + 1][curR][curC] = result[floor][curR][curC] + 1;
				q.offer(new int[] { floor + 1, curR, curC });
			}
			for (int i = 0; i < dr.length; i++) {
				int nr = curR + dr[i];
				int nc = curC + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[floor][nr][nc] && map[floor][nr][nc] != '#') {
					visited[floor][nr][nc] = true;
					result[floor][nr][nc] = result[floor][curR][curC] + 1;
					q.offer(new int[] { floor, nr, nc });

				}
			}
		}

	}
}
