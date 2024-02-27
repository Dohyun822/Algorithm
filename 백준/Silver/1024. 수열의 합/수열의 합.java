import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long N = Long.parseLong(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		for (int length = L; length <= 100; length++) {
			long temp = N - (length * (length - 1) / 2);
			if (temp % length == 0) {
				long a = temp / length;
				if (a >= 0) {
					for (int i = 0; i < length; i++) {
						System.out.print((a + i) + " ");
					}
					return;
				}
			}
		}
		System.out.println(-1);
	}
}