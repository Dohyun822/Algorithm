import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int K;
	private static int[] arr;
	private static boolean[] visited;
	private static int[] prev;
	private static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[100001];
		visited = new boolean[100001];
		prev = new int[100001];

		arr[N] = 0;

		bfs(N);

		System.out.println(arr[K]);

		stack = new Stack<Integer>();
		getRoute(K);

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

		System.out.print(K);
	}

	private static void getRoute(int k) {
		int cur = k;
		if (prev[cur] != -1) {
			stack.add(prev[cur]);
			getRoute(prev[cur]);
		}
	}

	private static void bfs(int cur) {
		Queue<Integer> q = new ArrayDeque<Integer>();

		q.offer(cur);
		prev[cur] = -1;
		visited[cur] = true;

		while (!q.isEmpty()) {
			int current = q.poll();
			if (current == K) {
				return;
			}
			int[] pos = new int[] { current - 1, current + 1, current * 2 };
			for (int move : pos) {
				if (move >= 0 && move < 100001 && !visited[move]) {
					arr[move] = arr[current] + 1;
					prev[move] = current;
					visited[move] = true;
					q.offer(move);
				}
			}
		}
	}
}
