import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int team;
		Node link;

		public Node(int team, Node link) {
			this.team = team;
			this.link = link;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			Node[] graph = new Node[N + 1];
			int[] indegree = new int[N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] lastYear = new int[N];
			for (int i = 0; i < N; i++) {
				lastYear[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					graph[lastYear[i]] = new Node(lastYear[j], graph[lastYear[i]]);
					indegree[lastYear[j]]++;
				}
			}

			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				Node tmp = graph[a];
				boolean found = false;
				while (tmp != null) {
					if (tmp.team == b) {
						found = true;
						break;
					}
					tmp = tmp.link;
				}

				if (found) {
					Node prev = null;
					tmp = graph[a];
					while (tmp != null) {
						if (tmp.team == b) {
							if (prev == null) {
								graph[a] = tmp.link;
							} else {
								prev.link = tmp.link;
							}
							indegree[b]--;
							break;
						}
						prev = tmp;
						tmp = tmp.link;
					}

					graph[b] = new Node(a, graph[b]);
					indegree[a]++;
				} else {
					Node prev = null;
					tmp = graph[b];
					while (tmp != null) {
						if (tmp.team == a) {
							if (prev == null) {
								graph[b] = tmp.link;
							} else {
								prev.link = tmp.link;
							}
							indegree[a]--;
							break;
						}
						prev = tmp;
						tmp = tmp.link;
					}

					graph[a] = new Node(b, graph[a]);
					indegree[b]++;
				}
			}

			Queue<Integer> q = new ArrayDeque<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= N; i++) {
				if (indegree[i] == 0) {
					q.offer(i);
				}
			}

			int count = 0;
			while (!q.isEmpty()) {
				if (q.size() > 1) {
					System.out.println("?");
					return;
				}
				int curr = q.poll();
				sb.append(curr).append(" ");
				count++;

				for (Node tmp = graph[curr]; tmp != null; tmp = tmp.link) {
					if (--indegree[tmp.team] == 0) {
						q.offer(tmp.team);
					}
				}
			}

			if (count == N) {
				System.out.println(sb.toString().trim());
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}