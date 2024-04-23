import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int answer = Integer.MAX_VALUE;

		int[][] soldier = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				soldier[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					int cnt = 0;
					for (int l = 0; l < N; l++) {
						if (soldier[i][0] >= soldier[l][0] && soldier[j][1] >= soldier[l][1]
								&& soldier[k][2] >= soldier[l][2]) {
							cnt++;
						}
					}
					if (cnt >= K) {
						answer = Math.min(answer, soldier[i][0] + soldier[j][1] + soldier[k][2]);
					}
				}
			}
		}

		System.out.println(answer);

	}
}