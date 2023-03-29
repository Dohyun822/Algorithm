import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] map;
	private static boolean[] visited;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			solve(i, i, 0, 0);
		}
		System.out.println(answer);

	}

	private static void solve(int start, int row, int sum, int cnt) {
		if (cnt == N - 1) {
			if (map[row][start] != 0) {
				answer = Math.min(answer, sum + map[row][0]);
			}
			return;
		}
		for (int i = 1; i < N; i++) {
			if (!visited[i] && map[row][i] != 0) {
				visited[i] = true;
				solve(start, i, sum + map[row][i], cnt + 1);
				visited[i] = false;
			}
		}
	}
}