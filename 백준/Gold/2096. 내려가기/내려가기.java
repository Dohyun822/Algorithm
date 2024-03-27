import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[][] map;
	private static int[][] max;
	private static int[][] min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N + 2][5];
		max = new int[N + 2][5];
		min = new int[N + 2][5];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (i == 1) {
					max[i][j] = temp;
					min[i][j] = temp;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= 3; j++) {
				max[i][j] = map[i][j] + Math.max(max[i - 1][j],
						Math.max(max[i - 1][Math.max(1, j - 1)], max[i - 1][Math.min(3, j + 1)]));
				min[i][j] = map[i][j] + Math.min(min[i - 1][j],
						Math.min(min[i - 1][Math.max(1, j - 1)], min[i - 1][Math.min(3, j + 1)]));
			}
		}

		int maxResult = Math.max(max[N][1], Math.max(max[N][2], max[N][3]));
		int minResult = Math.min(min[N][1], Math.min(min[N][2], min[N][3]));

		System.out.println(maxResult + " " + minResult);
	}
}