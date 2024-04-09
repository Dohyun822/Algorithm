import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
	private static int n;
	private static int m;
	private static int[][] map;
	private static int[][] grp;
	private static HashMap<Integer, Integer> szMap = new HashMap<>();
	private static int[] dr = { 0, 1, -1, 0 };
	private static int[] dc = { 1, 0, 0, -1 };
	private static int id = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		grp = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && grp[i][j] == 0) {
					int size = fill(i, j);
					szMap.put(id++, size);
				}
			}
		}

		System.out.println(findMax());
	}

	private static int fill(int r, int c) {
		if (r < 0 || c < 0 || r >= n || c >= m || map[r][c] == 0 || grp[r][c] != 0)
			return 0;
		grp[r][c] = id;
		int size = 1;
		for (int k = 0; k < 4; k++) {
			size += fill(r + dr[k], c + dc[k]);
		}
		return size;
	}

	private static int findMax() {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					int tmpSize = 1;
					HashMap<Integer, Boolean> visited = new HashMap<>();
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == 1
								&& !visited.containsKey(grp[nr][nc])) {
							tmpSize += szMap.get(grp[nr][nc]);
							visited.put(grp[nr][nc], true);
						}
					}
					max = Math.max(max, tmpSize);
				}
			}
		}
		return max;
	}
}