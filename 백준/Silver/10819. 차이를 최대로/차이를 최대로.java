import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[] arr;
	private static int[] selected;
	private static int max;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		selected = new int[N];
		visited = new boolean[N];
		max = Integer.MIN_VALUE;

		recur(0);

		System.out.println(max);
	}

	private static void recur(int depth) {
		if (depth == N) {
			check();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				selected[depth] = arr[i];
				visited[i] = true;
				recur(depth + 1);
				visited[i] = false;
			}
		}
	}

	private static void check() {
		int hap = 0;
		for (int i = 0; i < N - 1; i++) {
			hap += Math.abs(selected[i] - selected[i + 1]);
		}
		max = Math.max(max, hap);
	}

}