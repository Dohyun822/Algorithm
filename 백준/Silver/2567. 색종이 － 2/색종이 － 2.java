import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int R;
	private static int C;
	private static boolean[][] map;
	private static int answer;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		answer = 0;
		map = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			for (int r = R; r < R + 10; r++) {
				for (int c = C; c < C + 10; c++) {
					map[r][c] = true;
				}
			}
		}
		for (int r = 1; r < 101; r++) {
			for (int c = 1; c < 101; c++) {
				if (map[r][c]) {
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (nr <= 0 || nr > 100 || nc <= 0 || nc > 100 || !map[nr][nc]) {
							answer++;
						}
					}
				}

			}
		}
		System.out.println(answer);
	}// end of main
}// end of class