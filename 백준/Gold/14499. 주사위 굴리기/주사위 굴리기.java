import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int[] dice = new int[7];
	private static int[] dx = { 0, 0, 0, -1, 1 };
	private static int[] dy = { 0, 1, -1, 0, 0 };
	private static int N;
	private static int M;
	private static int x;
	private static int y;
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			int command = Integer.parseInt(st.nextToken());
			if (move(command)) {
				System.out.println(dice[1]);
			}
		}
	}

	private static boolean move(int command) {
		int nx = x + dx[command];
		int ny = y + dy[command];
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
			return false;
		}
		x = nx;
		y = ny;
		roll(command);
		if (map[x][y] == 0) {
			map[x][y] = dice[6];
		} else {
			dice[6] = map[x][y];
			map[x][y] = 0;
		}
		return true;
	}

	private static void roll(int command) {
		int[] temp = dice.clone();
		switch (command) {
		case 1:
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
			break;
		case 2:
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
			break;
		case 3:
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
			break;
		case 4:
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
			break;
		}
	}
}