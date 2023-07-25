import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static int M;
	private static String S;
	private static int answer;
	private static boolean[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();

		memo = new boolean[M];
		answer = 0;
		for (int i = 0; i <= M - (N * 2 + 1); i++) {
			if (S.charAt(i) == 'I') {
				check(i);
			}
		}

		System.out.println(answer);

	}

	private static void check(int i) {
		for (int j = 0, k = 1; j < N; j++, k += 2) {
			if (!memo[i + k]) {
				if (S.charAt(i + k) == 'I' || S.charAt(i + k + 1) == 'O') {
					return;
				}
			}
			memo[i + k] = true;
			memo[i + k + 1] = true;
		}
		answer++;
	}
}