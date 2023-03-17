import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static long A;
	private static long B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		System.out.println(f(B) - f(A - 1));
	}// end of main

	private static long f(long num) {
		long answer = num;
		long i = 2;
		while (i <= num) {
			answer += (num / i) * (i / 2);
			i *= 2;
		}
		return answer;

	}
}// end of class