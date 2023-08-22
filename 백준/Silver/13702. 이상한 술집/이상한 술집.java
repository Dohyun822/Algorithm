import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static long start;
	private static long end;
	private static long answer;
	private static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N];
		start = 1;
		end = 0;
		answer = 0;

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			arr[i] = temp;
			end = temp > end ? temp : end;
		}

		while (solve(start, end)) {
		}

		System.out.println(answer);
	}

	public static boolean solve(long start, long end) {
		if (start > end) {
			return false;
		}

		long mid = (start + end) / 2;
		long count = 0;
		for (int i = 0; i < N; i++) {
			count += arr[i] / mid;
		}

		if (count >= K) {
			answer = mid;
			return solve(mid + 1, end);
		} else {
			return solve(start, mid - 1);
		}
	}
}