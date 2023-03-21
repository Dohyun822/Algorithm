import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Country {
		int r;
		int c;

		public Country(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int answer;
	private static int N;
	private static int L;
	private static int R;
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<Country> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ex: while (true) {
			visited = new boolean[N][N];
			boolean move = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						int hap = bfs(i, j);
						if (arr.size() > 1) {
							move = true;
							int avg = hap / arr.size();
							for (Country x : arr) {
								map[x.r][x.c] = avg;
							}
						}
					}
				}
			}
			if (move) {
				answer++;
			} else {
				break ex;
			}
		}

		System.out.println(answer);
	}// end of main

	private static int bfs(int i, int j) {
		Queue<Country> q = new ArrayDeque<Country>();
		q.offer(new Country(i, j));
		arr = new ArrayList<Country>();
		arr.add(new Country(i, j));

		visited[i][j] = true;
		int hap = map[i][j];
		while (!q.isEmpty()) {
			Country temp = q.poll();
			int r = temp.r;
			int c = temp.c;
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && L <= Math.abs(map[r][c] - map[nr][nc])
						&& R >= Math.abs(map[r][c] - map[nr][nc]) && !visited[nr][nc]) {
					q.offer(new Country(nr, nc));
					arr.add(new Country(nr, nc));
					hap += map[nr][nc];
					visited[nr][nc] = true;
				}

			}
		}
		return hap;

	}
}// end of class