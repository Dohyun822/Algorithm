import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();

		int a_len = a.length();
		int b_len = b.length();

		int[][] dp = new int[a_len + 1][b_len + 1];

		for (int i = 1; i < a_len + 1; i++) {
			for (int j = 1; j < b_len + 1; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// LCS 문자열을 역추적
		StringBuilder answer = new StringBuilder();
		int i = a_len;
		int j = b_len;
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else if (dp[i][j] == dp[i][j - 1]) {
				j--;
			} else {
				answer.append(a.charAt(i - 1));
				i--;
				j--;
			}
		}

		System.out.println(dp[a_len][b_len]);
		System.out.println(answer.reverse().toString());
	}
}