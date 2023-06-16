import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int answer = 0;

		while (st.hasMoreTokens()) {
			int x = Integer.parseInt(st.nextToken());
			if (x == 1) {
				continue;
			}
			boolean chk = true;
			for (int i = 2; i <= Math.sqrt(x); i++) {
				if (x % i == 0) {
					chk = false;
					break;
				}
			}
			if (chk) {
				answer++;
			}
		}

		System.out.println(answer);

	} // end of main
}// end of class