import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int T;
	private static int A;
	private static int B;
	private static String[] target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			target = new String[10001];
			solve(A, B);
		}

	} // end of main

	private static void solve(int a, int b) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(a);
		target[a] = "";

		while (!q.isEmpty()) {
			int num = q.poll();
			if (num == b) {
				System.out.println(target[num]);
				return;
			}

			if (target[D(num)] == null) {
				target[D(num)] = target[num] + "D";
				q.offer(D(num));
			}
			if (target[S(num)] == null) {
				target[S(num)] = target[num] + "S";
				q.offer(S(num));
			}
			if (target[L(num)] == null) {
				target[L(num)] = target[num] + "L";
				q.offer(L(num));
			}
			if (target[R(num)] == null) {
				target[R(num)] = target[num] + "R";
				q.offer(R(num));
			}
		}

	}

	private static int D(int a) {
		return (a * 2) % 10000;
	}

	private static int S(int a) {
		if (a == 0) {
			return 9999;
		} else {
			return a - 1;
		}
	}

	private static int L(int a) {
		return a % 1000 * 10 + a / 1000;
	}

	private static int R(int a) {
		return a / 10 + a % 10 * 1000;
	}
}// end of class