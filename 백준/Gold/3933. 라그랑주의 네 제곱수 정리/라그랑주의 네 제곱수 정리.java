import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<Integer> results = new ArrayList<>();
	private static int maxN = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> input = new ArrayList<>();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			input.add(n);
			if (n > maxN) {
				maxN = n;
			}
		}

		int limit = (int) Math.sqrt(maxN) + 1;
		int[] squares = new int[limit];
		for (int i = 1; i < limit; i++) {
			squares[i] = i * i;
		}

		int[][][] dp = new int[maxN + 1][limit][5];
		for (int[][] arr : dp) {
			for (int[] arr2 : arr) {
				Arrays.fill(arr2, -1);
			}
		}

		for (int n : input) {
			results.add(recur(n, squares, 0, 1, 0, dp));
		}

		for (int result : results) {
			System.out.println(result);
		}
	}

	private static int recur(int n, int[] squares, int sum, int start, int depth, int[][][] dp) {
		if (sum == n && depth <= 4) {
			return 1;
		}
		if (sum > n || depth >= 4) {
			return 0;
		}

		if (dp[n - sum][start][depth] != -1) {
			return dp[n - sum][start][depth];
		}

		int result = 0;
		for (int i = start; i < squares.length; i++) {
			if (squares[i] > n) {
				break;
			}
			result += recur(n, squares, sum + squares[i], i, depth + 1, dp);
		}

		dp[n - sum][start][depth] = result;
		return result;
	}
}