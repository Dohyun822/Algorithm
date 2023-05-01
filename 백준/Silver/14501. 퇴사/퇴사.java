import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] list;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		list = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}

		answer = 0;
		solve(0, 0);
		System.out.println(answer);
	}// end of main

	private static void solve(int day, int total) {
		if (day > N) {
			return;
		}
		if (day == N) {
			answer = Math.max(answer, total);
			return;
		}
		solve(day + list[day][0], total + list[day][1]);
		solve(day + 1, total);
	}
}// end of class