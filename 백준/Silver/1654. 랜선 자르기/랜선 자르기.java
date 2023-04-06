import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int K;
	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		long max = 1;
		long min = 1;

		arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		while (min <= max) {
			int cnt = 0;
			long len = (min + max) / 2;
			for (int i = 0; i < K; i++) {
				cnt += arr[i] / len;
			}
			if (cnt >= N) {
				min = len + 1;
			} else {
				max = len - 1;
			}
		}
		System.out.println(max);

	}// end of main
}// end of class