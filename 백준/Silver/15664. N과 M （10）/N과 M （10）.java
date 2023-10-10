import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static int[] map;
	private static int[] result;
	private static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n];
		result = new int[m];
		visit = new boolean[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(map);
		bt(0, 0);

		System.out.print(sb);
	}

	private static void bt(int start, int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		int num = 0;
		for (int i = start; i < n; i++) {
			if (!visit[i]) {
				if (num == map[i]) {
					continue;
				}

				visit[i] = true;
				result[cnt] = map[i];
				bt(i + 1, cnt + 1);
				visit[i] = false;

				num = map[i];
			}
		}
	}
}