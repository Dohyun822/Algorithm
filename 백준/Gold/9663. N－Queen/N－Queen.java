import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = 0;
	private static int[] col;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		col = new int[N + 1];
		setQueen(1);
		System.out.println(answer);

	}// end of main

	private static void setQueen(int i) {
		if (!chk(i - 1)) {
			return;
		}
		if (i > N) {
			answer++;
			return;
		}
		for (int j = 1; j <= N; j++) {
			col[i] = j;
			setQueen(i + 1);
		}

	}

	private static boolean chk(int i) {
		for (int k = 1; k < i; k++) {
			if (col[k] == col[i] || Math.abs(col[k] - col[i]) == i - k) {
				return false;
			}
		}
		return true;
	}
}// end of class