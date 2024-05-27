import java.io.*;
import java.util.*;

public class Main {
	private static String arr;
	private static String devil;
	private static String angel;
	private static int scrollLength;
	private static int bridgeLength;
	private static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine();
		devil = br.readLine();
		angel = br.readLine();

		scrollLength = arr.length();
		bridgeLength = devil.length();
		dp = new int[scrollLength][bridgeLength][2];

		for (int[][] arr2 : dp) {
			for (int[] arr1 : arr2) {
				Arrays.fill(arr1, -1);
			}
		}

		int result = 0;
		for (int i = 0; i < bridgeLength; i++) {
			if (devil.charAt(i) == arr.charAt(0)) {
				result += recur(1, i, true);
			}
			if (angel.charAt(i) == arr.charAt(0)) {
				result += recur(1, i, false);
			}
		}

		System.out.println(result);
	}

	private static int recur(int scrollIdx, int bridgeIdx, boolean isDevil) {
		if (scrollIdx == scrollLength) {
			return 1;
		}

		if (dp[scrollIdx][bridgeIdx][isDevil ? 1 : 0] != -1) {
			return dp[scrollIdx][bridgeIdx][isDevil ? 1 : 0];
		}

		String currentBridge = isDevil ? angel : devil;
		int result = 0;

		for (int i = bridgeIdx + 1; i < bridgeLength; i++) {
			if (currentBridge.charAt(i) == arr.charAt(scrollIdx)) {
				result += recur(scrollIdx + 1, i, !isDevil);
			}
		}

		dp[scrollIdx][bridgeIdx][isDevil ? 1 : 0] = result;
		return result;
	}
}