import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] order;
	static boolean[] isSelected;
	static int[] input = { 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[][] result;
	static boolean[] ground;
	private static int N;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		result = new int[N + 1][10];
		order = new int[10];
		isSelected = new boolean[10];
		order[4] = 1;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(1);
		System.out.println(answer);

	} // end of main

	private static void solve(int index) {
		if (index == 4) {
			index++;
		}
		if (index == 10) {
			getanswer();
			return;
		}
		for (int i = 0; i < input.length; i++) {
			if (isSelected[i]) {
				continue;
			}
			order[index] = input[i];
			isSelected[i] = true;
			solve(index + 1);
			isSelected[i] = false;
		}
	}

	private static void getanswer() {
		int score = 0;
		int start = 1;
		for (int i = 1; i <= N; i++) {
			ground = new boolean[4];
			int outCnt = 0;

			while (outCnt != 3) {
				switch (result[i][order[start]]) {
				case 0:
					start++;
					outCnt++;
					break;
				case 1:
					start++;
					if (ground[3]) {
						score++;
						ground[3] = false;
					}
					for (int j = 2; j >= 1; j--) {
						if (ground[j]) {
							ground[j + 1] = true;
							ground[j] = false;
						}
					}
					ground[1] = true;
					break;
				case 2:
					start++;
					if (ground[3]) {
						score++;
						ground[3] = false;
					}
					if (ground[2]) {
						score++;
					}
					if (ground[1]) {
						ground[3] = true;
						ground[1] = false;
					}
					ground[2] = true;
					break;
				case 3:
					start++;
					for (int j = 1; j <= 3; j++) {
						if (ground[j]) {
							score++;
							ground[j] = false;
						}
					}
					ground[3] = true;

					break;
				case 4:
					start++;
					int groundplayer = 1;
					for (int j = 1; j <= 3; j++) {
						if (ground[j]) {
							groundplayer++;
							ground[j] = false;
						}
					}
					score += groundplayer;
					break;

				}
				if (start == 10) {
					start = 1;
				}
			}
			answer = Math.max(answer, score);

		}
	}
}// end of class