import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] sum = new int[N];
		sum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int k = 0; k < M; k++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			if (i == 0) {
				answer = sum[j];
			} else {
				answer = sum[j] - sum[i - 1];
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());

	}// end of main
}// end of class