import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int a;
	private static int b;
	private static int n;
	private static int w;
	private static int x;
	private static int y;
	private static int ansX;
	private static int ansY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		x = 0;
		y = 0;
		ansX = 0;
		ansY = 0;
		int chk = 0;
		for (x = 1; x < n; x++) {
			y = n - x;
			if ((a * x + b * y) == w) {
				chk++;
				ansX = x;
				ansY = y;
				if (chk > 1) {
					break;
				}
			}
		}
		if (chk == 1) {
			System.out.println(ansX + " " + ansY);
		} else {
			System.out.println(-1);
		}

	}
}