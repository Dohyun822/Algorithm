import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Rc {
		int r;
		int c;

		public Rc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int M;
	static int[][] map;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		Rc rc = new Rc(0, 0);
		bfs(rc);
		System.out.println(cnt);

	}// end of main

	private static void bfs(Rc rc) {
		Queue<Rc> q = new ArrayDeque<Rc>();
		q.offer(rc);
		int row = 0;
		int col = 0;
		while (!q.isEmpty()) {
			Rc current = q.poll();

			row = current.r;
			col = current.c;
			cnt = map[row][col];
			map[row][col] = 500;
			if (row == N - 1 && col == M - 1) {
				return;
			}
			if (row - 1 >= 0 && map[row - 1][col] == 1) {
				q.offer(new Rc(row - 1, col));
				map[row - 1][col] = cnt + 1;
			}
			if (row + 1 < N && map[row + 1][col] == 1) {
				q.offer(new Rc(row + 1, col));
				map[row + 1][col] = cnt + 1;
			}
			if (col - 1 >= 0 && map[row][col - 1] == 1) {
				q.offer(new Rc(row, col - 1));
				map[row][col - 1] = cnt + 1;
			}
			if (col + 1 < M && map[row][col + 1] == 1) {
				q.offer(new Rc(row, col + 1));
				map[row][col + 1] = cnt + 1;
			}
		}

	}

}// end of class