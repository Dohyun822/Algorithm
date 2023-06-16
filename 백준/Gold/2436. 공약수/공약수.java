import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int A;
	private static int B;
	private static long N;
	private static long hap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		N = (long) A * B;
		
		hap = Long.MAX_VALUE;

		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (N % i == 0) {
				long x = i;
				long y = N / i;

				while (x % y != 0) {
					long temp = x % y;
					x = y;
					y = temp;
				}

				if (y == A) {
					x = i;
					y = N / i;
					if ((x + y) <= hap) {
						hap = x + y;
						sb = new StringBuilder();
						sb.append(x).append(" ").append(y);
					}
				}

			}
		}

		System.out.println(sb.toString());

	}
}