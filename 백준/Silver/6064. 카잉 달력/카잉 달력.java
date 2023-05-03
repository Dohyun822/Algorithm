import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int T;
	private static int M;
	private static int N;
	private static int x;
	private static int y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			int year = x;
			int lastYear = getLast(M, N);

			if (year > lastYear) {
				System.out.println(-1);
				continue;
			}
			while (true) {
				if (((year % N) == 0 ? N : year % N) == y) {
					System.out.println(year);
					break;
				} else if (year > lastYear) {
					System.out.println(-1);
					break;
				}

				year += M;
			}
		}

	}// end of main

	private static int getLast(int m, int n) {
		int mn = m * n;
		int temp = 0;
		while (n > 0) {
			temp = m % n;
			m = n;
			n = temp;
		}
		return mn / m;
	}
}// end of class