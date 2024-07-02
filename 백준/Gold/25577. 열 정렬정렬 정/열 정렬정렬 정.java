import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[] arr;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visited = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] arrSorted = new int[N + 1];
		System.arraycopy(arr, 1, arrSorted, 1, N);
		Arrays.sort(arrSorted, 1, N + 1);

		HashMap<Integer, Integer> mp = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			mp.put(arrSorted[i], i);
		}

		for (int i = 1; i <= N; i++) {
			arr[i] = mp.get(arr[i]);
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				int cycleLen = dfs(i);
				ans += cycleLen - 1;
			}
		}

		System.out.println(ans);
	}

	private static int dfs(int start) {
		int cnt = 0;
		int cur = start;
		while (!visited[cur]) {
			visited[cur] = true;
			cnt++;
			cur = arr[cur];
		}
		return cnt;
	}
}