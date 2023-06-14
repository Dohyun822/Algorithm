import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int C;
	private static int N;
	private static int[] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		C = Integer.parseInt(br.readLine());

		answer = new int[1001];
		answer[1] = 3;

		for (int i = 2; i < 1001; i++) {
			int cnt = 0;
			for (int j = 1; j <= i; j++) {
				int a = i;
				int b = j;
				while (a % b != 0) {
					int temp = a % b;
					a = b;
					b = temp;
				}
				if (b == 1) {
					cnt++;
				}
			}
			answer[i] = answer[i - 1] + cnt * 2;
		}

		for (int i = 0; i < C; i++) {
			N = Integer.parseInt(br.readLine());
			sb.append(answer[N]).append("\n");
		}
		System.out.println(sb.toString());

	}
}