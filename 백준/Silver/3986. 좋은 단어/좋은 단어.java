import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();

			for (int j = 0; j < s.length(); j++) {
				if (j == 0) {
					stack.push(s.charAt(j));
					continue;
				}
				if (stack.size() != 0 && stack.peek() == s.charAt(j)) {
					stack.pop();
				} else {
					stack.push(s.charAt(j));
				}
			}

			if (stack.size() == 0) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}