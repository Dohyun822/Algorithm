import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] map;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		answer = 0;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(new int[] { 1, 1 }, new int[] { 1, 2 }, 0);

		System.out.println(answer);
	}

	private static void solve(int[] start, int[] end, int dir) {
		if (end[0] == N && end[1] == N) {
			answer++;
			return;
		}
		switch (dir) {
		// 가로
		case 0:
			// 오른쪽 이동
			if (end[1] + 1 <= N && map[end[0]][end[1] + 1] == 0) {
				solve(new int[] { end[0], end[1] }, new int[] { end[0], end[1] + 1 }, 0);
			}
			// 대각 이동
			if (end[0] + 1 <= N && end[1] + 1 <= N && map[end[0] + 1][end[1] + 1] == 0 && map[end[0]][end[1] + 1] == 0
					&& map[end[0] + 1][end[1]] == 0) {
				solve(new int[] { end[0], end[1] }, new int[] { end[0] + 1, end[1] + 1 }, 2);
			}
			break;
		// 세로
		case 1:
			// 아래 이동
			if (end[0] + 1 <= N && map[end[0] + 1][end[1]] == 0) {
				solve(new int[] { end[0], end[1] }, new int[] { end[0] + 1, end[1] }, 1);
			}
			// 대각 이동
			if (end[0] + 1 <= N && end[1] + 1 <= N && map[end[0] + 1][end[1] + 1] == 0 && map[end[0]][end[1] + 1] == 0
					&& map[end[0] + 1][end[1]] == 0) {
				solve(new int[] { end[0], end[1] }, new int[] { end[0] + 1, end[1] + 1 }, 2);
			}
			break;
		// 대각선
		case 2:
			// 오른쪽 이동
			if (end[1] + 1 <= N && map[end[0]][end[1] + 1] == 0) {
				solve(new int[] { end[0], end[1] }, new int[] { end[0], end[1] + 1 }, 0);
			}
			// 아래 이동
			if (end[0] + 1 <= N && map[end[0] + 1][end[1]] == 0) {
				solve(new int[] { end[0], end[1] }, new int[] { end[0] + 1, end[1] }, 1);
			}
			// 대각 이동
			if (end[0] + 1 <= N && end[1] + 1 <= N && map[end[0] + 1][end[1] + 1] == 0 && map[end[0]][end[1] + 1] == 0
					&& map[end[0] + 1][end[1]] == 0) {
				solve(new int[] { end[0], end[1] }, new int[] { end[0] + 1, end[1] + 1 }, 2);
			}
			break;

		}
	}
}// end of class