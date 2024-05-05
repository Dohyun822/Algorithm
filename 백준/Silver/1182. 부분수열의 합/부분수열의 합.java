import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int S;
	private static int[] arr;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		answer = 0;

		for (int i = 0; i < N; i++) {
			recur(i, arr[i], 1);
		}

		System.out.println(answer);
	}

	private static void recur(int index, int sum, int count) {
		if (sum == S && count > 0) {
			answer++;
		}

		for (int i = index + 1; i < N; i++) {
			recur(i, sum + arr[i], count + 1);
		}
	}

}