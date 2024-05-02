import java.io.*;
import java.util.*;

public class Main {
	private static int[] selected;
	private static int N;
	private static int M;
	private static StringBuilder sb;
	private static boolean[] visited;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		visited = new boolean[N];
		selected = new int[M];

		recur(0, 0);

		System.out.println(sb.toString());

	}

	private static void recur(int start, int depth) {
		if (depth == M) {
			print();
			return;
		}

		for (int i = 0; i < N; i++) {
			selected[depth] = arr[i];
			recur(i + 1, depth + 1);
		}
	}

	private static void print() {
		for (int i = 0; i < M; i++) {
			sb.append(selected[i]).append(" ");
		}
		sb.append('\n');

	}
}