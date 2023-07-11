import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		solve(0, 1);
		System.out.println(sb.toString());

	}// end of main

	public static void solve(int cnt, int start) {
		if (cnt == M) {
			for (int i : numbers) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			solve(cnt + 1, i + 1);
		}
	}
}// end of class