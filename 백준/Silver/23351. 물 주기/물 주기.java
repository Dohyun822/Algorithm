import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static int A;
	private static int B;
	private static int[] flower;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		flower = new int[N];
		Arrays.fill(flower, K);

		int day = 1;
		int idx = 0;
		while (true) {
			for (int i = idx; i < idx + A; i++) {
				flower[i % N] += B;
			}
			for (int i = 0; i < N; i++) {
				if (--flower[i] == 0) {
					System.out.println(day);
					return;
				}
			}
			day++;
			idx = (idx + A) % N;
		}

	}// end of main
}// end of class