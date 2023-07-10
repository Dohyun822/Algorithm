import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int S;
	private static int[] arr;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		answer = 0;
		recur(0, 0);
		if (S == 0 && answer > 0) {
			answer--;
		}

		System.out.println(answer);

	}

	private static void recur(int cur, int total) {
		if (cur == N) {
			if (total == S) {
				answer++;
			}
			return;
		}
		recur(cur + 1, total + arr[cur]);
		recur(cur + 1, total);
	}
}