import java.io.*;
import java.util.*;

public class Main {
	static int M, N, K;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		paper = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					paper[y][x] = 1;
				}
			}
		}

		List<Integer> areas = new ArrayList<>();
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (paper[y][x] == 0 && !visited[y][x]) {
					areas.add(bfs(x, y));
				}
			}
		}

		Collections.sort(areas);
		System.out.println(areas.size());
		for (int area : areas) {
			System.out.print(area + " ");
		}
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[y][x] = true;

		int area = 0;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			area++;

			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[ny][nx] && paper[ny][nx] == 0) {
					queue.offer(new int[] { nx, ny });
					visited[ny][nx] = true;
				}
			}
		}
		return area;
	}
}