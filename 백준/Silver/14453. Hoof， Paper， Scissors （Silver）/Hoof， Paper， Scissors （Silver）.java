import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	private static int N;
	private static int[][] arr;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			char c = br.readLine().charAt(0);
			for (int j = 0; j < 3; j++) {
				arr[i][j] = arr[i - 1][j];
			}
			if (c == 'H') {
				arr[i][0] = arr[i - 1][0] + 1; // Hoof
			} else if (c == 'S') {
				arr[i][1] = arr[i - 1][1] + 1; // Scissors
			} else {
				arr[i][2] = arr[i - 1][2] + 1; // Paper
			}
		}

		answer = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 1; k <= N; k++) {
					answer = Math.max(answer, arr[k][i] + arr[N][j] - arr[k][j]);
				}
			}
		}

		System.out.println(answer);
	}
}