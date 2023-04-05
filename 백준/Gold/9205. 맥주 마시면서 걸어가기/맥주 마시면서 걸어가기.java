import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int t;
	private static int n;
	private static int festivalX;
	private static int festivalY;
	private static int houseY;
	private static int houseX;
	private static boolean[] visited;
	private static Store[] storePoint;
	static StringBuilder sb = new StringBuilder();

	static class Store {
		int x;
		int y;
		int idx;

		public Store(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());

			visited = new boolean[n];
			storePoint = new Store[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			houseX = Integer.parseInt(st.nextToken());
			houseY = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				storePoint[j] = new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), j);
			}
			st = new StringTokenizer(br.readLine(), " ");
			festivalX = Integer.parseInt(st.nextToken());
			festivalY = Integer.parseInt(st.nextToken());

			solve(houseX, houseY);

		}
		System.out.println(sb.toString());
	}

	private static void solve(int x, int y) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(x);
		q.offer(y);

		while (!q.isEmpty()) {
			int nx = q.poll();
			int ny = q.poll();
			if (getDistance(festivalX, nx, festivalY, ny) > 1000) {
				ArrayList<Store> list = findStore(nx, ny);
				for (int i = 0; i < list.size(); i++) {
					q.offer(list.get(i).x);
					q.offer(list.get(i).y);
					visited[list.get(i).idx] = true;
				}
				if (q.isEmpty()) {
					sb.append("sad").append("\n");
				}

			} else {
				sb.append("happy").append("\n");
				break;
			}
		}

	}

	private static ArrayList<Store> findStore(int nx, int ny) {
		ArrayList<Store> list = new ArrayList<>();
		for (int i = 0; i < storePoint.length; i++) {
			if (getDistance(storePoint[i].x, nx, storePoint[i].y, ny) <= 1000 && !visited[i]) {
				list.add(storePoint[i]);
			}
		}
		return list;

	}

	private static int getDistance(int X, int X2, int Y, int Y2) {
		return Math.abs(X - X2) + Math.abs(Y - Y2);
	}
}