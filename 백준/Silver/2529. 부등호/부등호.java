import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int k;
	static char[] op = new char[20];
	static ArrayList<String> result = new ArrayList<>();
	static boolean[] check = new boolean[10];

	static boolean validate(char op, char num1, char num2) {
		if (op == '<') {
			if (num1 > num2)
				return false;
		}
		if (op == '>') {
			if (num1 < num2)
				return false;
		}
		return true;
	}

	static void dfs(int idx, String num) {
		if (idx == k + 1) {
			result.add(num);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (!check[i]) {
				if (idx == 0 || validate(op[idx - 1], num.charAt(idx - 1), (char) (i + '0'))) {
					check[i] = true;
					dfs(idx + 1, num + Integer.toString(i));
					check[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < k; i++) {
			op[i] = input[i].charAt(0);
		}

		dfs(0, "");
		Collections.sort(result);

		System.out.println(result.get(result.size() - 1));
		System.out.println(result.get(0));
	}
}