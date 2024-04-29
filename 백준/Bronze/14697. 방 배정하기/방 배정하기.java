import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int A;
	private static int B;
	private static int C;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		if (A == N || B == N || C == N) {
			System.out.println(1);
			return;
		}

		for (int i = 0; i <= 300; i++) {
			if (i * A == N) {
				System.out.println(1);
				return;
			} else if (i * B == N) {
				System.out.println(1);
				return;
			} else if (i * C == N) {
				System.out.println(1);
				return;
			}
			for (int j = 0; j <= 300; j++) {
				if (i * A + j * B == N) {
					System.out.println(1);
					return;
				} else if (i * A + j * C == N) {
					System.out.println(1);
					return;
				} else if (i * B + j * C == N) {
					System.out.println(1);
					return;
				}
				for (int k = 0; k <= 300; k++) {
					if (i * A + j * B + k * C == N) {
						System.out.println(1);
						return;
					}
				}
			}
		}

		System.out.println(0);

	}// end of main
}// end of class