import java.io.*;
import java.util.*;

public class Main {
	private static int[][] square = new int[3][3];
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recur(0, 0, new int[3][3], new boolean[10]);
		System.out.println(answer);
	}

	private static void recur(int row, int col, int[][] magicSquare, boolean[] used) {
		if (row == 3) {
			if (chk(magicSquare)) {
				int cost = getCost(square, magicSquare);
				answer = Math.min(answer, cost);
			}
			return;
		}
		if (col == 3) {
			recur(row + 1, 0, magicSquare, used);
			return;
		}
		for (int num = 1; num <= 9; num++) {
			if (!used[num]) {
				used[num] = true;
				magicSquare[row][col] = num;
				recur(row, col + 1, magicSquare, used);
				used[num] = false;
			}
		}
	}

	private static boolean chk(int[][] m) {
		int sum = m[0][0] + m[0][1] + m[0][2];
		for (int i = 1; i < 3; i++) {
			if (m[i][0] + m[i][1] + m[i][2] != sum)
				return false;
		}
		for (int j = 0; j < 3; j++) {
			if (m[0][j] + m[1][j] + m[2][j] != sum)
				return false;
		}
		if (m[0][0] + m[1][1] + m[2][2] != sum)
			return false;
		if (m[0][2] + m[1][1] + m[2][0] != sum)
			return false;
		return true;
	}

	private static int getCost(int[][] square, int[][] magicSquare) {
		int cost = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cost += Math.abs(square[i][j] - magicSquare[i][j]);
			}
		}
		return cost;
	}
}