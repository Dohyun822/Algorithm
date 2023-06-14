import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static long N;
	private static String input;
	private static long reverse;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		input = br.readLine();

		for (int i = 0; i < input.length(); i++) { // 3,4,7 이면 뒤집었을 때 숫자가 아님
			if (input.charAt(i) == '3' || input.charAt(i) == '4' || input.charAt(i) == '7') {
				System.out.println("no");
				return;
			}
		}

		N = Long.parseLong(input);

		if (N == 1) {
			System.out.println("no");
			return;
		}

		// N이 소수인지 체크
		if (check(N)) {
			System.out.println("no");
			return;
		}

		// 뒤집힌 수 구하기
		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) == '0' || input.charAt(i) == '1' || input.charAt(i) == '2' || input.charAt(i) == '5'
					|| input.charAt(i) == '8') {
				sb.append(input.charAt(i));
			} else if (input.charAt(i) == '6') {
				sb.append('9');
			} else {
				sb.append('6');
			}
		}

		reverse = Long.parseLong(sb.toString());

		// 뒤집힌 수가 소수인지 체크
		if (check(reverse)) {
			System.out.println("no");
			return;
		}

		System.out.println("yes");

	}

	private static boolean check(long num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return true;
			}
		}
		return false;
	}
}