import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	static StringBuilder sb = new StringBuilder();

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static ArrayList<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];

		for (int r = 0; r < 9; r++) {
			String s = br.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = s.charAt(c) - '0';
				if (map[r][c] == 0) {
					list.add(new Point(r, c));
				}
			}
		}

		solve(0);
		System.out.println(sb.toString());

	}

	private static void solve(int cnt) {
		if (cnt == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}
		boolean[] chk = new boolean[10];
		int nr = list.get(cnt).r;
		int nc = list.get(cnt).c;

		for (int i = 0; i < 9; i++) {
			if (map[nr][i] != 0) {
				chk[map[nr][i]] = true;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (map[i][nc] != 0) {
				chk[map[i][nc]] = true;
			}
		}

		switch (nr) {
		case 0:
		case 1:
		case 2:
			if (nc < 3) {
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (map[r][c] != 0) {
							chk[map[r][c]] = true;
						}
					}
				}
			} else if (nc < 6) {
				for (int r = 0; r < 3; r++) {
					for (int c = 3; c < 6; c++) {
						if (map[r][c] != 0) {
							chk[map[r][c]] = true;
						}
					}
				}
			} else {
				for (int r = 0; r < 3; r++) {
					for (int c = 6; c < 9; c++) {
						if (map[r][c] != 0) {
							chk[map[r][c]] = true;
						}
					}
				}
			}

			break;
		case 3:
		case 4:
		case 5:
			if (nc < 3) {
				for (int r = 3; r < 6; r++) {
					for (int c = 0; c < 3; c++) {
						if (map[r][c] != 0) {
							chk[map[r][c]] = true;
						}
					}
				}
			} else if (nc < 6) {
				for (int r = 3; r < 6; r++) {
					for (int c = 3; c < 6; c++) {
						if (map[r][c] != 0) {
							chk[map[r][c]] = true;
						}
					}
				}
			} else {
				for (int r = 3; r < 6; r++) {
					for (int c = 6; c < 9; c++) {
						if (map[r][c] != 0) {
							chk[map[r][c]] = true;
						}
					}
				}
			}
			break;

		case 6:
		case 7:
		case 8:
			if (nc < 3) {
				for (int r = 6; r < 9; r++) {
					for (int c = 0; c < 3; c++) {
						if (map[r][c] != 0) {
							chk[map[r][c]] = true;
						}
					}
				}
			} else if (nc < 6) {
				for (int r = 6; r < 9; r++) {
					for (int c = 3; c < 6; c++) {
						if (map[r][c] != 0) {
							chk[map[r][c]] = true;
						}
					}
				}
			} else {
				for (int r = 6; r < 9; r++) {
					for (int c = 6; c < 9; c++) {
						if (map[r][c] != 0) {
							chk[map[r][c]] = true;
						}
					}
				}
			}
			break;

		} // end of switch

		for (int i = 1; i <= 9; i++) {
			if (!chk[i]) {
				map[nr][nc] = i;
				solve(cnt + 1);
				map[nr][nc] = 0;
			}
		}
	}
}