import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		int len = word.length();
		String answer = "";

		for (int i = 1; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				String temp1 = word.substring(0, i);
				String temp2 = word.substring(i, j);
				String temp3 = word.substring(j, len);

				String a = solve(temp1);
				String b = solve(temp2);
				String c = solve(temp3);

				String result = a + b + c;

				if (answer == "" || result.compareTo(answer) < 0) {
					answer = result;
				}
			}
		}

		System.out.println(answer);
	}

	private static String solve(String temp) {
		StringBuilder sb = new StringBuilder(temp);
		return sb.reverse().toString();
	}
}
