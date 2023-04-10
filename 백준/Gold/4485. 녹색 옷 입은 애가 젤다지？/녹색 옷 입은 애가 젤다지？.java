import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Temp implements Comparable<Temp> {
		int r;
		int c;
		int weight;

		public Temp(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		public int compareTo(Temp o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static int N;
	private static int[][] map;
	private static int cnt;
	private static int[][] distance;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}

			map = new int[N][N];
			distance = new int[N][N];
			for (int[] arr : distance) {
				Arrays.fill(arr, 9999999);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = solve();

			sb.append("Problem ").append(cnt).append(":").append(" ").append(answer).append("\n");
			cnt++;

		}
		System.out.println(sb.toString());

	}// end of main

	private static int solve() {
		PriorityQueue<Temp> pq = new PriorityQueue<Temp>();
		pq.add(new Temp(0, 0, map[0][0]));
		while (!pq.isEmpty()) {
			Temp current = pq.poll();
			for (int i = 0; i < dc.length; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (distance[nr][nc] > current.weight + map[nr][nc]) {
						distance[nr][nc] = current.weight + map[nr][nc];
						pq.offer(new Temp(nr, nc, distance[nr][nc]));
						if (nr == N - 1 && nc == N - 1) {
							return distance[N - 1][N - 1];
						}
					}
				}
			}
		}
		return distance[N - 1][N - 1];
	}
}// end of class