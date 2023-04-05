import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int L;
	private static int[][] map;
	private static int answer;
	private static boolean[] chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 0;
		for (int i = 0; i < N; i++) {
			chkRow(i);
			chkCol(i);
		}
		System.out.println(answer);
	}

	private static void chkCol(int i) {
		chk = new boolean[N];
		int len = 1;
		for (int c = 0; c < N - 1; c++) {
			int H = map[i][c];
			int nextH = map[i][c + 1];
			int temp = nextH - H;
			switch (temp) {
			case 1: // 오르막길
				if (len >= L) {
					for (int j = 0; j < L; j++) {
						if (chk[c - j]) {
							return;
						} else {
							chk[c - j] = true;
						}
					}
				} else {
					return;
				}
				break;
			case -1: // 내리막길
				len = 0;
				if (c + L >= N) {
					return;
				}
				if (L == 1) {
					chk[c + 1] = true;
					break;
				}
				for (int j = 1; j < L; j++) {
					if (map[i][c + 1] == map[i][c + 1 + j]) {
						chk[c + 1 + j] = true;
					} else {
						return;
					}
				}
				c = c + L - 1;
				break;
			case 0: // 평지
				len++;
				break;

			default:
				return;
			}
		}
		answer++;
	}

	private static void chkRow(int i) {
		chk = new boolean[N];
		int len = 1;
		for (int c = 0; c < N - 1; c++) {
			int H = map[c][i];
			int nextH = map[c + 1][i];
			int temp = nextH - H;
			switch (temp) {
			case 1: // 오르막길
				if (len >= L) {
					for (int j = 0; j < L; j++) {
						if (chk[c - j]) {
							return;
						} else {
							chk[c - j] = true;
						}
					}
				} else {
					return;
				}
				break;
			case -1: // 내리막길
				len = 0;
				if (c + L >= N) {
					return;
				}
				if (L == 1) {
					chk[c + 1] = true;
					break;
				}
				for (int j = 1; j < L; j++) {
					if (map[c + 1][i] == map[c + 1 + j][i]) {
						chk[c + 1 + j] = true;
					} else {
						return;
					}
				}
				c = c + L - 1;
				break;
			case 0: // 평지
				len++;
				break;

			default:
				return;
			}
		}
		answer++;
	}
}