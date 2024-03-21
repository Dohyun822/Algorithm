import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static List<int[]> homes = new ArrayList<>();
	private static List<int[]> chickens = new ArrayList<>();
	private static int minDistance = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					homes.add(new int[] { i, j });
				else if (map[i][j] == 2)
					chickens.add(new int[] { i, j });
			}
		}

		combination(new ArrayList<>(), 0);
		System.out.println(minDistance);
	}

	private static void combination(ArrayList<int[]> selected, int start) {
		if (selected.size() == M) {
			calculateDistance(selected);
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			selected.add(chickens.get(i));
			combination(selected, i + 1);
			selected.remove(selected.size() - 1);
		}
	}

	private static void calculateDistance(ArrayList<int[]> selectedChickens) {
		int totalDistance = 0;
		for (int[] home : homes) {
			int distance = Integer.MAX_VALUE;
			for (int[] chicken : selectedChickens) {
				distance = Math.min(distance, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
			}
			totalDistance += distance;
		}
		minDistance = Math.min(minDistance, totalDistance);
	}
}