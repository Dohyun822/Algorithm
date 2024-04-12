import java.io.*;
import java.util.*;

public class Main {
	static int[][] map = new int[4][4];
	static int[][] direction = new int[4][4];
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 방향에 따른 x, y 변화량
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int maxSum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				direction[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		// 상어가 초기 위치의 물고기를 먹음
		int startFish = map[0][0];
		int sharkDir = direction[0][0];
		map[0][0] = -1; // 상어 위치를 -1로 표시

		// 물고기 이동, 상어 이동을 시뮬레이션
		simulate(0, 0, sharkDir, startFish);

		System.out.println(maxSum);
	}

	static void simulate(int sharkX, int sharkY, int sharkDir, int currentSum) {
		int[][] tempMap = new int[4][4];
		int[][] tempDir = new int[4][4];

		for (int i = 0; i < 4; i++) {
			tempMap[i] = Arrays.copyOf(map[i], 4);
			tempDir[i] = Arrays.copyOf(direction[i], 4);
		}

		moveFishes();

		// 상어 이동 가능한 모든 경우 탐색
		for (int step = 1; step <= 3; step++) {
			int nx = sharkX + dx[sharkDir] * step;
			int ny = sharkY + dy[sharkDir] * step;

			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) {
				int eatenFish = map[nx][ny];
				int newDir = direction[nx][ny];
				map[sharkX][sharkY] = 0;
				map[nx][ny] = -1; // 상어 이동

				simulate(nx, ny, newDir, currentSum + eatenFish);

				// 상태 복원
				map[sharkX][sharkY] = -1;
				map[nx][ny] = eatenFish;
			}
		}

		// 물고기와 방향 상태 복원
		for (int i = 0; i < 4; i++) {
			map[i] = Arrays.copyOf(tempMap[i], 4);
			direction[i] = Arrays.copyOf(tempDir[i], 4);
		}

		maxSum = Math.max(maxSum, currentSum);
	}

	static void moveFishes() {
		for (int num = 1; num <= 16; num++) {
			outer: for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (map[i][j] == num) {
						int d = direction[i][j];
						for (int k = 0; k < 8; k++) {
							int nd = (d + k) % 8;
							int nx = i + dx[nd];
							int ny = j + dy[nd];
							if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1) {
								// 물고기 위치 교환
								map[i][j] = map[nx][ny];
								map[nx][ny] = num;
								direction[i][j] = direction[nx][ny];
								direction[nx][ny] = nd;
								break outer;
							}
						}
					}
				}
			}
		}
	}
}