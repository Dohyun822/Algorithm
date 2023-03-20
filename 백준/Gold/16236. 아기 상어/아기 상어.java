import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int dis;

		public Fish(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dis == o.dis) {
				return this.r - o.r == 0 ? this.c - o.c : this.r - o.r;
			}
			return this.dis - o.dis;
		}

	}

	private static int N;
	private static int[][] map;
	private static int[][] distance;
	private static int[] shark;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int sharkSize = 2;
	static int eatCnt;
	static int answer;
	private static ArrayList<Fish> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		shark = new int[2];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 9) {
					shark[0] = r;
					shark[1] = c;
					map[r][c] = 0;
				}
			}
		}

		while (true) {
			bfs(shark);

			if (arr.size() == 0) {
				break;
			} else {
				Collections.sort(arr);
				shark[0] = arr.get(0).r;
				shark[1] = arr.get(0).c;
				answer += arr.get(0).dis;
				eatCnt++;
				if (eatCnt == sharkSize) {
					sharkSize++;
					eatCnt = 0;
				}
				map[arr.get(0).r][arr.get(0).c] = 0;
			}
		}
		System.out.println(answer);
	}

	private static void bfs(int[] sharkPoint) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(sharkPoint);
		arr = new ArrayList<Fish>();
		distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], -1);
		}
		distance[sharkPoint[0]][sharkPoint[1]] = 0;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int r = current[0];
			int c = current[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (distance[nr][nc] == -1 && map[nr][nc] <= sharkSize) {
						distance[nr][nc] = distance[r][c] + 1;
						if (map[nr][nc] != 0 && map[nr][nc] < sharkSize) {
							arr.add(new Fish(nr, nc, distance[nr][nc]));
						}
						q.offer(new int[] { nr, nc });
					}

				}
			}
		}
	}
}// end of class