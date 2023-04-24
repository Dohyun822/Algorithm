import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] map;
	private static int answer1;
	private static int answer2;
	private static int answer3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer1 = 0;
		answer2 = 0;
		answer3 = 0;
		solve(0, 0, N);

		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);

	}// end of main

	private static void solve(int r, int c, int size) {
		boolean chk = true;
		int first = map[r][c];
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (first != map[i][j]) {
					chk = false;
					break;
				}
			}
		}

		int tempSize = size / 3;
		if (!chk) {
			solve(r, c, tempSize);
			solve(r, c + tempSize, tempSize);
			solve(r, c + 2 * tempSize, tempSize);

			solve(r + tempSize, c, tempSize);
			solve(r + tempSize, c + tempSize, tempSize);
			solve(r + tempSize, c + 2 * tempSize, tempSize);

			solve(r + 2 * tempSize, c, tempSize);
			solve(r + 2 * tempSize, c + tempSize, tempSize);
			solve(r + 2 * tempSize, c + 2 * tempSize, tempSize);

		} else {
			switch (first) {
			case -1:
				answer1++;
				break;
			case 0:
				answer2++;
				break;
			case 1:
				answer3++;
				break;

			}
		}

	}
}// end of class