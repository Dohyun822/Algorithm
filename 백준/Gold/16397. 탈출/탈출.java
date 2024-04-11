import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int T;
	private static int G;
	private static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());

		check = new boolean[100000];

		int answer = solve();

		if (answer <= T) {
			System.out.println(answer);
		} else {
			System.out.println("ANG");
		}

	}

	private static int solve() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { N, 0 });

		check[N] = true;
		while (!q.isEmpty()) {

			int[] cur = q.poll();
			int value = cur[0];
			int count = cur[1];
			if (value == G) {
				return count;
			}
			if (count > T) {
				break;
			}

			int nextA = value + 1;
			if (nextA < 100000 && !check[nextA]) {
				check[nextA] = true;
				q.offer(new int[] { nextA, count + 1 });
			}

			int nextB = operateB(value);

			if (nextB < 100000 && !check[nextB]) {
				check[nextB] = true;
				q.offer(new int[] { nextB, count + 1 });
			}
		}
		return Integer.MAX_VALUE;
	}

	private static int operateB(int current) {
		if (current == 0) {
			return 0;
		}
		current *= 2;
		if (current > 99999) {
			return Integer.MAX_VALUE;
		}
		int highest = 1;
		while (highest * 10 <= current) {
			highest *= 10;
		}
		return current - highest;
	}
}