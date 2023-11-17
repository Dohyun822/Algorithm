import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static long N;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());

		arr = new int[1000001];

		for (int i = 2; i < 1000001; i++) {
			arr[i] = i;
		}

		for (int i = 2; i < 100001; i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i * 2; j < 1000001; j += i) {
				arr[j] = 0;
			}
		}

		ex: for (int i = 0; i < N; i++) {
			long S = Long.parseLong(br.readLine());
			for (int j = 2; j < 1000001; j++) {
				if (arr[j] != 0) {
					if (S % arr[j] == 0) {
						System.out.println("NO");
						continue ex;
					}
				}
			}
			System.out.println("YES");
		}
	}
}