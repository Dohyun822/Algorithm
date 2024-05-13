import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int K;
	private static int[][] arr;
	private static int maxTaste = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Integer> combination = new ArrayList<>();
		recur(combination, 0);
		System.out.println(maxTaste);
	}

	static void recur(List<Integer> selected, int start) {
		if (selected.size() == K) {
			maxTaste = Math.max(maxTaste, cal(selected));
			return;
		}

		for (int i = start; i < N; i++) {
			selected.add(i);
			recur(selected, i + 1);
			selected.remove(selected.size() - 1);
		}
	}

	static int cal(List<Integer> selected) {
		int taste = 0;
		for (int i = 0; i < selected.size(); i++) {
			for (int j = i + 1; j < selected.size(); j++) {
				int idx1 = selected.get(i);
				int idx2 = selected.get(j);
				taste += arr[idx1][idx2];
			}
		}
		return taste;
	}
}
