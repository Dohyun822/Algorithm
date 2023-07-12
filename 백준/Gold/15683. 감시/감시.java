import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class cctv {
		int num;
		int r;
		int c;

		public cctv(int num, int r, int c) {
			this.num = num;
			this.r = r;
			this.c = c;
		}

	}

	static int N;
	static int M;
	static int answer;
	static int[][] map;
	static int[][] map2;
	static int[] order;
	static ArrayList<cctv> cc;

	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력 및 cctv 종류와 위치 저장
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = N * M;
		map = new int[N][M];
		map2 = new int[N][M];
		cc = new ArrayList<cctv>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
//				if (temp == 5) {
//					for (int k = i - 1; k >= 0; k--) { // 상
//						if (map[k][j] == 6) {
//							break;
//						} else if (map[k][j] == 0) {
//							map[k][j] = '#';
//						}
//					}
//					for (int k = i + 1; k < N; k++) { // 하
//						if (map[k][j] == 6) {
//							break;
//						} else if (map[k][j] == 0) {
//							map[k][j] = '#';
//						}
//					}
//					for (int k = j - 1; k >= 0; k--) {// 좌
//						if (map[i][k] == 6) {
//							break;
//						} else if (map[i][k] == 0) {
//							map[i][k] = '#';
//						}
//
//					}
//					for (int k = j + 1; k < M; k++) {// 우
//						if (map[i][k] == 6) {
//							break;
//						} else if (map[i][k] == 0) {
//							map[i][k] = '#';
//						}
//
//					}
//				}
				if (map[i][j] == 0) {
					map[i][j] = temp;

				} else if (map[i][j] == '#' && temp != 0) {
					map[i][j] = temp;
				}
				if (temp != 0 && temp != '#' && temp != 6) {
					cc.add(new cctv(map[i][j], i, j));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map2[i][j] = map[i][j];
			}
		}

		order = new int[cc.size()];
		for (int i = 0; i < args.length; i++) {

		}
		perm(0, cc.size()); // 중복순열

		System.out.println(answer);

	}// end of main

	private static void perm(int index, int size) {
		if (answer == 0) {
			return;
		}
		if (index == size) {
			map2 = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map2[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < order.length; i++) {
				solve(cc.get(i), order[i]);
			}

			getanswer();

			return;
		}
		for (int i = 0; i < 4; i++) {// 0 1 2 3 => 상 하 좌 우
			order[index] = i;
			perm(index + 1, size);
		}

	}

	private static void getanswer() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map2[i][j] == 0) {
					cnt++;
				}
			}
		}
		answer = Math.min(answer, cnt);

	}

	private static void solve(cctv cctv, int i) {
		int ccNum = cctv.num;
		if (ccNum == 1) {
			switch (i) {// 상 하 좌 우
			case 0:
				chk(cctv, 0);
				break;
			case 1:
				chk(cctv, 1);
				break;
			case 2:
				chk(cctv, 2);
				break;
			case 3:
				chk(cctv, 3);
				break;

			}
		} else if (ccNum == 2) {// 상 하 // 좌 우
			switch (i) {
			case 0:
				chk(cctv, 0);
				chk(cctv, 1);
				break;
			case 1:
				chk(cctv, 0);
				chk(cctv, 1);
				break;
			case 2:
				chk(cctv, 2);
				chk(cctv, 3);
				break;
			case 3:
				chk(cctv, 2);
				chk(cctv, 3);
				break;

			}
		} else if (ccNum == 3) {// 상우 //하좌 // 좌상 //우하
			switch (i) {
			case 0:
				chk(cctv, 0);
				chk(cctv, 3);
				break;
			case 1:
				chk(cctv, 1);
				chk(cctv, 2);
				break;
			case 2:
				chk(cctv, 2);
				chk(cctv, 0);
				break;
			case 3:
				chk(cctv, 3);
				chk(cctv, 1);
				break;

			}
		} else if (ccNum == 4) {
			switch (i) {
			case 0:
				chk(cctv, 0);
				chk(cctv, 2);
				chk(cctv, 3);
				break;
			case 1:
				chk(cctv, 1);
				chk(cctv, 2);
				chk(cctv, 3);
				break;
			case 2:
				chk(cctv, 2);
				chk(cctv, 0);
				chk(cctv, 1);
				break;
			case 3:
				chk(cctv, 3);
				chk(cctv, 0);
				chk(cctv, 1);
				break;

			}
		} else if (ccNum == 5) {
			chk(cctv, 0);
			chk(cctv, 1);
			chk(cctv, 2);
			chk(cctv, 3);
		}
	}

	private static void chk(cctv cctv, int i) {
		Queue<cctv> q = new ArrayDeque<cctv>();
		q.offer(cctv);

		while (!q.isEmpty()) {
			int nr = q.peek().r + dr[i];
			int nc = q.poll().c + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M || map2[nr][nc] == 6) {
				break;
			}

			if (map2[nr][nc] == 0) {
				map2[nr][nc] = '#';
				q.offer(new cctv(cctv.num, nr, nc));
			} else {
				q.offer(new cctv(cctv.num, nr, nc));
			}
		}
	}
}// end of class