import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[] numbers;
	private static int[] operators;
	private static int maxResult = Integer.MIN_VALUE;
	private static int minResult = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		operators = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		recur(numbers[0], 1);

		System.out.println(maxResult);
		System.out.println(minResult);
	}

	private static void recur(int num, int depth) {
		if (depth == N) {
			maxResult = Math.max(maxResult, num);
			minResult = Math.min(minResult, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;
				recur(calculate(num, numbers[depth], i), depth + 1);
				operators[i]++;
			}
		}
	}

	private static int calculate(int num1, int num2, int x) {
		switch (x) {
		case 0:
			return num1 + num2;
		case 1:
			return num1 - num2;
		case 2:
			return num1 * num2;
		case 3:
			return num1 / num2;
		default:
			return 0;
		}
	}
}
