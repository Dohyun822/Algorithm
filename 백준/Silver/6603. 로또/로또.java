import java.io.*;
import java.util.*;

public class Main {
	private static int[] selected;
	private static int N;
	private static int M = 6; // 로또 번호는 항상 6개를 선택
	private static StringBuilder sb;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		sb = new StringBuilder();

		while (!(line = br.readLine()).equals("0")) {
			StringTokenizer st = new StringTokenizer(line, " ");
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;

			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			selected = new int[M];

			recur(0, 0);
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

	private static void recur(int start, int depth) {
		if (depth == M) {
			print();
			return;
		}

		for (int i = start; i < N; i++) {
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