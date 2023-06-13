import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		System.out.println(solve(N));

	}

	private static int solve(int n) {
		long sum = 0;
		int i = 2;
		while (i <= n / 2) {
			int x = n / i;
			int y = n / x;
			long c = (long) (x - 1) * (y - i + 1) * (i + y) / 2;
			sum = (sum + c) % 1000000;
			i = y + 1;
		}

		return (int) sum;
	}// end of main
}// end of class