import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] fibo = new int[30];
		fibo[0] = 1;
		fibo[1] = 2;
		for (int i = 2; i < 30; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int x = Integer.parseInt(br.readLine());
			int[] b = new int[30];
			int idx = 29;

			while (x > 0) {
				if (fibo[idx] <= x) {
					x -= fibo[idx];
					b[idx] = 1;
				}
				idx--;
			}

			int y = 0;
			for (int j = 1; j < 30; j++) {
				y += b[j] * fibo[j - 1];
			}

			sb.append(y).append("\n");
		}

		System.out.println(sb.toString());
	}
}