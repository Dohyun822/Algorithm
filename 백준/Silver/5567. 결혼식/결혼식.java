import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] arr = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);
		}

		boolean visited[] = new boolean[n + 1];

		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(1);
		visited[1] = true;

		int cnt = 0;
		int chk = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				for (int x : arr[cur]) {
					if (!visited[x]) {
						visited[x] = true;
						q.add(x);
						cnt++;
					}
				}
			}
			chk++;
			if (chk == 2) {
				break;
			}
		}

		System.out.println(cnt);

	}
}
