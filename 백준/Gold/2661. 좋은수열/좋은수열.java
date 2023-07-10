import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		recur(0, "");

	}

	private static void recur(int cur, String result) {
		if (cur == N) {
			System.out.println(result);
			System.exit(0);
		}

		for (int i = 1; i <= 3; i++) {
			if (check(result + i)) {
				recur(cur + 1, result + i);
			}
		}
	}

	private static boolean check(String string) {
		int len = string.length();
		for (int i = 1; i <= len / 2; i++) {
			String front = string.substring(len - i - i, len - i);
			String back = string.substring(len - i, len);
			if (front.equals(back)) {
				return false;
			}
		}
		return true;
	}
}