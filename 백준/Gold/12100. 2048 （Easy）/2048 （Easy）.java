import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[][] board;
	private static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, board);
		System.out.println(answer);
	}

	private static int[][] copy(int[][] board) {
		if (board == null) {
			return null;
		}

		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(board[i], 0, result[i], 0, N);
		}

		return result;
	}

	private static int[][] moveLeft(int[][] b) {
		for (int i = 0; i < N; i++) {
			int pos = 0;
			for (int j = 1; j < N; j++) {
				if (b[i][j] != 0) {
					int val = b[i][j];
					b[i][j] = 0;

					if (b[i][pos] == 0) {
						b[i][pos] = val;
					} else if (b[i][pos] == val) {
						b[i][pos] *= 2;
						pos++;
					} else {
						pos++;
						b[i][pos] = val;
					}
				}
			}
		}
		return b;
	}

	private static int[][] moveRight(int[][] b) {
		for (int i = 0; i < N; i++) {
			int pos = N - 1;
			for (int j = N - 2; j >= 0; j--) {
				if (b[i][j] != 0) {
					int val = b[i][j];
					b[i][j] = 0;

					if (b[i][pos] == 0) {
						b[i][pos] = val;
					} else if (b[i][pos] == val) {
						b[i][pos] *= 2;
						pos--;
					} else {
						pos--;
						b[i][pos] = val;
					}
				}
			}
		}
		return b;
	}

	private static int[][] moveUp(int[][] b) {
		for (int j = 0; j < N; j++) {
			int pos = 0;
			for (int i = 1; i < N; i++) {
				if (b[i][j] != 0) {
					int val = b[i][j];
					b[i][j] = 0;

					if (b[pos][j] == 0) {
						b[pos][j] = val;
					} else if (b[pos][j] == val) {
						b[pos][j] *= 2;
						pos++;
					} else {
						pos++;
						b[pos][j] = val;
					}
				}
			}
		}
		return b;
	}

	private static int[][] moveDown(int[][] b) {
		for (int j = 0; j < N; j++) {
			int pos = N - 1;
			for (int i = N - 2; i >= 0; i--) {
				if (b[i][j] != 0) {
					int val = b[i][j];
					b[i][j] = 0;

					if (b[pos][j] == 0) {
						b[pos][j] = val;
					} else if (b[pos][j] == val) {
						b[pos][j] *= 2;
						pos--;
					} else {
						pos--;
						b[pos][j] = val;
					}
				}
			}
		}
		return b;
	}

	private static void dfs(int depth, int[][] arr) {
		if (depth == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > answer) {
						answer = arr[i][j];
					}
				}
			}
			return;
		}

		dfs(depth + 1, moveLeft(copy(arr)));
		dfs(depth + 1, moveRight(copy(arr)));
		dfs(depth + 1, moveUp(copy(arr)));
		dfs(depth + 1, moveDown(copy(arr)));
	}
}