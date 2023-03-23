import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final String S = null;
	static int N;
	static int M;
	static int K;
	static int answer = 5000;
	static int[][] arr;
	static int[][] temp;
	static int[][] rcs;
	static int[][] dorcs;
	static boolean[] isSelected;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		rcs = new int[K][3];
		dorcs = new int[K][3];
		isSelected = new boolean[K];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rcs[i][0] = Integer.parseInt(st.nextToken());
			rcs[i][1] = Integer.parseInt(st.nextToken());
			rcs[i][2] = Integer.parseInt(st.nextToken());
		}

		solve(0);

		System.out.println(answer);

	}// end of main

	public static void solve(int cnt) {
		if (cnt == K) {
			temp = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					temp[i][j] = arr[i][j];
				}
			}

			for (int i = 0; i < K; i++) {
				rotate(dorcs[i][0], dorcs[i][1], dorcs[i][2]);
//				for (int j = 0; j < arr.length; j++) {
//					System.out.println(Arrays.toString(temp[j]));
//				}
//				System.out.println();
			}

			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += temp[i][j];
				}
				answer = Math.min(answer, sum);
			}
			return;
		}

		for (int i = 0; i < K; i++) {
			if (isSelected[i]) {
				continue;
			}
			dorcs[cnt][0] = rcs[i][0];
			dorcs[cnt][1] = rcs[i][1];
			dorcs[cnt][2] = rcs[i][2];
			isSelected[i] = true;
			solve(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static void rotate(int r, int c, int s) {
		int minr = r - s;
		int maxr = r + s;
		int minc = c - s;
		int maxc = c + s;
		for (int i = 0; i < s; i++) {
			int tempval = temp[minr][minc];
			int startr = minr;
			int startc = minc;
			int k = 0;
			for (int j = 0; j < (maxr - minr + 1) * 4 - 4; j++) {
				int nr = startr + dr[k];
				int nc = startc + dc[k];

				if (nr < minr || nr > maxr || nc < minc || nc > maxc) {
					k = (k + 1) % 4;
					nr = startr + dr[k];
					nc = startc + dc[k];
				}
				temp[startr][startc] = temp[nr][nc];
				startr = nr;
				startc = nc;
			}
			temp[minr][minc + 1] = tempval;
			minr++;
			maxr--;
			minc++;
			maxc--;
		}
	}

}// end of class