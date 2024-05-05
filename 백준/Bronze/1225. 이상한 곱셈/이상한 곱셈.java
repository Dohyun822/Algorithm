import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String s1 = st.nextToken();
		String s2 = st.nextToken();

		long ans = solve(s1, s2);

		System.out.println(ans);
	}

	private static long solve(String s1, String s2) {
		long result = 0;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				int num1 = s1.charAt(i) - '0';
				int num2 = s2.charAt(j) - '0';
				result += (long) num1 * num2;
			}
		}
		return result;
	}
}