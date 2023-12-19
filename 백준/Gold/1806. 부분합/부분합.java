import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = Integer.MAX_VALUE;

		while (true) {
			if (sum >= S) {
				answer = Math.min(answer, end - start);
				sum -= arr[start++];
			} else if (end == N) {
				break;
			} else {
				sum += arr[end++];
			}
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}

}