import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean[] chk = new boolean[N + 1];

		for (int i = 0; i < B; i++) {
			int temp = Integer.parseInt(br.readLine());
			chk[temp] = true;
		}

		int answer = Integer.MAX_VALUE;
		int cur = 0;

		for (int i = 1; i <= K; i++) {
			if (chk[i]) {
				cur++;
			}
		}
		answer = cur;

		for (int i = K + 1; i <= N; i++) {
			if (chk[i]) {
				cur++;
			}
			if (chk[i - K]) {
				cur--;
			}
			answer = Math.min(answer, cur);
		}

		System.out.println(answer);
	}
}
