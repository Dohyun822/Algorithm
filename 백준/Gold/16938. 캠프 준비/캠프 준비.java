import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int L;
	private static int R;
	private static int X;
	private static int[] level;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		level = new int[N];

		for (int i = 0; i < N; i++) {
			level[i] = Integer.parseInt(st.nextToken());
		}

		answer = 0;

		recur(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

		System.out.println(answer);
	}

	private static void recur(int index, int count, int min, int max, int hap) {
		if (index == N) {
			if (count >= 2 && hap >= L && hap <= R && (max - min) >= X) {
				answer++;
			}
			return;
		}

		recur(index + 1, count + 1, Math.min(min, level[index]), Math.max(max, level[index]), hap + level[index]);
		recur(index + 1, count, min, max, hap);

	}
}
