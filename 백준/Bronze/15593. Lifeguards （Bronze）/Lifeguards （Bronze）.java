import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] shifts = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			shifts[i][0] = Integer.parseInt(st.nextToken());
			shifts[i][1] = Integer.parseInt(st.nextToken());
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			boolean[] chk = new boolean[1001];

			for (int j = 0; j < N; j++) {
				if (i != j) {
					for (int t = shifts[j][0]; t < shifts[j][1]; t++) {
						chk[t] = true;
					}
				}
			}

			int cur = 0;
			for (int t = 0; t <= 1000; t++) {
				if (chk[t])
					cur++;
			}

			max = Math.max(max, cur);
		}

		System.out.println(max);
	}
}