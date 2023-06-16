import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long N;
	private static int A;
	private static long answer;
	private static long X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Long.parseLong(st.nextToken());

		if (N == 0) {
			System.out.println(0);
			return;
		}

		A = Integer.parseInt(st.nextToken());

		X = A;

		answer = 0;

		while (X <= N) {
			int cnt = (int) (N / X);
			answer += cnt;
			X *= A;
		}

		System.out.println(answer);

	} // end of main
}// end of class
