import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		answer = 0;

		for (int num = 123; num <= 987; num++) {
			String s = Integer.toString(num);
			if (s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(2) == s.charAt(0)) {
				continue;
			}
			if (s.contains("0")) {
				continue;
			}

			boolean chk = true;

			for (int i = 0; i < N; i++) {
				int query = arr[i][0];
				int strike = arr[i][1];
				int ball = arr[i][2];
				int s_s = 0;
				int s_b = 0;

				String q = Integer.toString(query);

				for (int j = 0; j < 3; j++) {
					if (s.charAt(j) == q.charAt(j)) {
						s_s++;
					} else if (s.contains(String.valueOf(q.charAt(j)))) {
						s_b++;
					}
				}

				if (s_s != strike || s_b != ball) {
					chk = false;
					break;
				}

			}

			if (chk) {
				answer++;
			}

		}
		System.out.println(answer);

	}
}