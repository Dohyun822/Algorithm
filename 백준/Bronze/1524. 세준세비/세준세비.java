import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] s = new int[N];
			int[] b = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(s);
			Arrays.sort(b);

			int jIndex = 0, bIndex = 0;
			while (jIndex < N && bIndex < M) {
				if (s[jIndex] < b[bIndex]) {
					jIndex++;
				} else {
					bIndex++;
				}
			}

			if (jIndex == N) {
				sb.append("B\n");
			} else {
				sb.append("S\n");
			}
		}

		System.out.print(sb.toString());
	}
}