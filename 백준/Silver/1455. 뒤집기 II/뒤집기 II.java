import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);

		int[][] coins = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				coins[i][j] = line.charAt(j) - '0';
			}
		}

		int answer = 0;

		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (coins[i][j] == 1) {
					answer++;
					solve(coins, i, j);
				}
			}
		}

		System.out.println(answer);
	}

	private static void solve(int[][] coins, int a, int b) {
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				coins[i][j] = 1 - coins[i][j];
			}
		}
	}
}