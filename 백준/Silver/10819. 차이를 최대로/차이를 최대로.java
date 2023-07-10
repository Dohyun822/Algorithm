import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] arr;
	private static int answer;
	private static boolean[] visited;
	private static int[] permuteArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		answer = Integer.MIN_VALUE;
		visited = new boolean[N];
		permuteArr = new int[N];

		permute(0);

		System.out.println(answer);

	}

	private static void permute(int cur) {
		if (cur == N) {
			solve();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permuteArr[cur] = arr[i];
				permute(cur + 1);
				visited[i] = false;
			}
		}

	}

	private static void solve() {
		int hap = 0;
		for (int i = 0; i < N - 1; i++) {
			hap += Math.abs(permuteArr[i] - permuteArr[i + 1]);
		}
		answer = Math.max(answer, hap);
	}
}