import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[21];

		if (N == 0) {
			System.out.println("NO");
			return;
		}

		int start = 1;
		for (int i = 0; i < 21; i++) {
			if (start > N)
				break;
			arr[i] = start;
			start *= 3;
		}

		System.out.println(solve(N, 20) ? "YES" : "NO");
	}

	private static boolean solve(int n, int index) {
		if (n == 0) {
			return true;
		}
		if (index < 0 || n < 0)
			return false;

		return solve(n - arr[index], index - 1) || solve(n, index - 1);
	}

}
