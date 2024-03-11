import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		solve(0, 0, N);
		System.out.print(sb.toString());
	}

	private static void solve(int r, int c, int size) {
		int half = size / 2;
		if (chk(r, c, size)) {
			sb.append(arr[r][c]);
			return;
		}

		sb.append("(");
		solve(r, c, half);
		solve(r, c + half, half);
		solve(r + half, c, half);
		solve(r + half, c + half, half);
		sb.append(")");

	}

	private static boolean chk(int r, int c, int size) {
		int temp = arr[r][c];
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != temp) {
					return false;
				}
			}
		}
		return true;
	}
}// end of class
