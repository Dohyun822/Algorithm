import java.io.*;
import java.util.*;

public class Main {
	private static int[][] sudoku = new int[9][9];
	private static boolean found = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0);
	}

	private static void solve(int row, int col) {
		if (col == 9) {
			solve(row + 1, 0);
			return;
		}
		if (row == 9) {
			printSudoku();
			found = true;
			return;
		}
		if (sudoku[row][col] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (canPlace(row, col, num)) {
					sudoku[row][col] = num;
					solve(row, col + 1);
					if (found)
						return;
					sudoku[row][col] = 0;
				}
			}
		} else {
			solve(row, col + 1);
		}
	}

	private static boolean canPlace(int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[row][i] == num || sudoku[i][col] == num)
				return false;
		}
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudoku[startRow + i][startCol + j] == num)
					return false;
			}
		}
		return true;
	}

	private static void printSudoku() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}