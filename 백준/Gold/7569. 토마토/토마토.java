import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int h;
		int r;
		int c;

		public Position(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}

	}

	private static int M;
	private static int N;
	private static int H;
	private static int[][][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static boolean[][][] visited;
	private static int cnt;
	private static ArrayList<Position> list = new ArrayList<Position>();
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		visited = new boolean[H][N][M];
		cnt = 0;
		answer = 0;

		for (int i = 0; i < H; i++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < M; c++) {
					map[i][r][c] = Integer.parseInt(st.nextToken());
					if (map[i][r][c] == 0) {
						cnt++;
					} else if (map[i][r][c] == 1) {
						list.add(new Position(i, r, c));
					}
				}
			}
		}

		if (cnt == 0) {
			System.out.println(0);
			return;
		}

		while (true) {
			bfs();
			answer++;
			if (cnt == 0) {
				System.out.println(answer);
				break;
			}
			if (list.size() == 0 && cnt > 0) {
				System.out.println(-1);
				break;
			}

		}

	}// end of main

	private static void bfs() {
		Queue<Position> q = new ArrayDeque<Position>();
		for (Position position : list) {
			q.offer(position);
			visited[position.h][position.r][position.c] = true;
		}
		list.clear();

		while (!q.isEmpty()) {
			Position temp = q.poll();
			int h = temp.h;
			int nr = temp.r;
			int nc = temp.c;
			// 아래층
			if (h - 1 >= 0 && map[h - 1][nr][nc] == 0 && !visited[h - 1][nr][nc]) {
				list.add(new Position(h - 1, nr, nc));
				map[h - 1][nr][nc] = 1;
				visited[h - 1][nr][nc] = true;
				cnt--;
			}

			// 위층
			if (h + 1 < H && map[h + 1][nr][nc] == 0 && !visited[h + 1][nr][nc]) {
				list.add(new Position(h + 1, nr, nc));
				map[h + 1][nr][nc] = 1;
				visited[h + 1][nr][nc] = true;
				cnt--;
			}
			for (int j = 0; j < dr.length; j++) {
				int NR = nr + dr[j];
				int NC = nc + dc[j];
				if (NR >= 0 && NR < N && NC >= 0 && NC < M) {
					// 현재층
					if (map[h][NR][NC] == 0 && !visited[h][NR][NC]) {
						list.add(new Position(h, NR, NC));
						map[h][NR][NC] = 1;
						visited[h][NR][NC] = true;
						cnt--;
					}
				}
			}
		}

	}
}// end of class