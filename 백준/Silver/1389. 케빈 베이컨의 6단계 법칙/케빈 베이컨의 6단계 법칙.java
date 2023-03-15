import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Info implements Comparable<Info> {
		int answer;
		int kebin;

		public Info(int answer, int kebin) {
			this.answer = answer;
			this.kebin = kebin;
		}

		@Override
		public int compareTo(Info o) {
			return this.kebin == o.kebin ? Integer.compare(this.answer, o.answer)
					: Integer.compare(this.kebin, o.kebin);
		}

	}

	private static int N;
	private static int M;
	static ArrayList<Integer>[] arr;
	private static int A;
	private static int B;
	private static ArrayList<Info> answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			arr[A].add(B);
			arr[B].add(A);
		}

		answer = new ArrayList<Info>();

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		Collections.sort(answer);

		System.out.println(answer.get(0).answer);

	}// end of main

	private static void bfs(int i) {
		Queue<Info> q = new ArrayDeque<Info>();
		q.offer(new Info(i, 0));
		boolean[] visited = new boolean[N + 1];
		visited[i] = true;
		int cnt = 0;
		int kebin = 0;

		while (!q.isEmpty()) {
			Info temp = q.poll();
			int cur = temp.answer;
			cnt = temp.kebin;
			for (int friend : arr[cur]) {
				if (!visited[friend]) {
					q.offer(new Info(friend, cnt + 1));
					kebin += cnt + 1;
					visited[friend] = true;
				}
			}

		}
		answer.add(new Info(i, kebin));

	}
}// end of class