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
	static class Point {
		int r;
		int c;
		int val;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

	}

	private static int R;
	private static int C;
	private static int T;
	static int answer;
	private static int[][] map;
	static ArrayList<Point> dustPoint;
	static ArrayList<Point> dustPoint2;
	static ArrayList<Point> cleanPoint;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		dustPoint = new ArrayList<Point>();
		dustPoint2 = new ArrayList<Point>();
		cleanPoint = new ArrayList<Point>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == -1) {
					cleanPoint.add(new Point(i, j));
				} else if (temp != 0) {
					dustPoint.add(new Point(i, j, temp));
				}
			}
		}

		for (int i = 0; i < T; i++) {
			map = new int[R][C];
			// 미세먼지 확산
			for (int j = 0; j < dustPoint.size(); j++) {
				int cnt = 0;
				int r = dustPoint.get(j).r;
				int c = dustPoint.get(j).c;
				int val = dustPoint.get(j).val;
				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C
							&& !(nr == cleanPoint.get(0).r && nc == cleanPoint.get(0).c)
							&& !(nr == cleanPoint.get(1).r && nc == cleanPoint.get(1).c)) {
						map[nr][nc] += val / 5;
						cnt++;
					}
				}
				map[r][c] += val - ((val / 5) * cnt);
			}

			// 먼지위치 입력
			dustPoint.clear();
			dustPoint2.clear();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] != 0) {
						dustPoint2.add(new Point(r, c, map[r][c]));
					}
				}
			}

			// 공기청정기 작동
			for (int j = 0; j < dustPoint2.size(); j++) {
				int r = dustPoint2.get(j).r;
				int c = dustPoint2.get(j).c;
				int val = dustPoint2.get(j).val;
				if (c == cleanPoint.get(0).c) {
					if (r < cleanPoint.get(0).r && r + 1 != cleanPoint.get(0).r) {
						dustPoint.add(new Point(r + 1, c, val));
					} else if (r > cleanPoint.get(1).r && r - 1 != cleanPoint.get(1).r) {
						dustPoint.add(new Point(r - 1, c, val));
					}
				} else if (r == 0 || r == R - 1) {
					if (c - 1 >= 0) {
						dustPoint.add(new Point(r, c - 1, val));
					}
				} else if (c == C - 1) {
					if (r <= cleanPoint.get(0).r && r - 1 >= 0) {
						dustPoint.add(new Point(r - 1, c, val));
					} else if (r >= cleanPoint.get(1).r && r + 1 < R) {
						dustPoint.add(new Point(r + 1, c, val));
					}
				} else if (r == cleanPoint.get(0).r && c + 1 < C) {
					dustPoint.add(new Point(r, c + 1, val));
				} else if (r == cleanPoint.get(1).r && c + 1 < C) {
					dustPoint.add(new Point(r, c + 1, val));
				} else {
					dustPoint.add(new Point(r, c, val));
				}
			}
		}
		map = new int[R][C];
		for (int i = 0; i < dustPoint.size(); i++) {
			map[dustPoint.get(i).r][dustPoint.get(i).c] = dustPoint.get(i).val;
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0) {
					answer += map[i][j];
				}
			}
		}
		System.out.println(answer);
	}

}// end of class