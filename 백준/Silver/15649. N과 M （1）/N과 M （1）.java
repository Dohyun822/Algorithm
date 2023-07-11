import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] selected;
	private static StringBuilder sb;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M];
		visited = new boolean[N + 1];

		recur(0);

		System.out.println(sb.toString());

	}

	private static void recur(int cur) {
		if (cur == M) {
			for (int i : selected) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				continue;
			}
			selected[cur] = i;
			visited[i] = true;
			recur(cur + 1);
			visited[i] = false;
		}
	}
}