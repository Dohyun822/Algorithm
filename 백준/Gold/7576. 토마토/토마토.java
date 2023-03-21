import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class tomato {
		int r;
		int c;

		public tomato(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	private static int N;
	private static int M;
	private static int[][] map;
	private static int[][] day;
	static Queue<tomato> q = new ArrayDeque<tomato>();

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		day = new int[M][N];

		for (int i = 0; i < M; i++) {
			Arrays.fill(day[i], -1);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new tomato(i, j));
					day[i][j] = 0;
				}
			}
		}
		answer = 0;
		bfs();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				answer = Math.max(answer, day[i][j]);
			}
		}
		System.out.println(answer);
	}// end of main

	private static void bfs() {
		while (!q.isEmpty()) {
			tomato temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];
				if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
					if (day[nr][nc] == -1 && map[nr][nc] == 0) {
						map[nr][nc] = 1;
						day[nr][nc] = day[temp.r][temp.c] + 1;
						q.offer(new tomato(nr, nc));
					}
				}

			}
		}
	}
}// end of class