import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int max = 1;
		int min = 0;

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		while (min < max) {
			long cnt = 0;
			int len = (min + max) / 2;
			for (int i = 0; i < N; i++) {
				if (arr[i] - len < 0) {
					continue;
				}
				cnt += arr[i] - len;
			}
			if (cnt >= M) {
				min = len + 1;
			} else {
				max = len;
			}
		}
		System.out.println(min - 1);

	}// end of main
}// end of class