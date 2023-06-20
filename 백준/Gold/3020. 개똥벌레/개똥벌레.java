import java.io.*;
import java.util.*;

public class Main {

	private static int N;
	private static int H;
	private static int[] imos;
	private static int[] imos2;
	private static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		imos = new int[H + 2];
		imos2 = new int[H + 2];

		for (int i = 1; i <= N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (i % 2 == 1) {
				imos[1] += 1;
				imos[x + 1] -= 1;
			} else {
				imos2[H] += 1;
				imos2[H - x] -= 1;
			}
		}

		for (int i = 1; i <= H; i++) {
			imos[i] += imos[i - 1];
		}
		for (int i = H; i >= 0; i--) {
			imos2[i] += imos2[i + 1];
		}

		int min = 999999999;
		int hap = 0;
		int cnt = 0;
		for (int i = 1; i <= H; i++) {
			hap = imos[i] + imos2[i];
			if (hap < min) {
				min = hap;
				cnt = 0;
			}
			if (hap == min) {
				cnt++;
			}
		}

		System.out.println(min + " " + cnt);

	}
}