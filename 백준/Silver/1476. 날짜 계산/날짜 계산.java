import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int e = 1, s = 1, m = 1;
		for (int year = 1;; year++) {
			if (e == E && s == S && m == M) {
				System.out.println(year);
				break;
			}
			e = (e % 15) + 1;
			s = (s % 28) + 1;
			m = (m % 19) + 1;
		}
	}
}
