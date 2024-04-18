import java.io.*;
import java.util.*;

public class Main {
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int[] arr = new int[N];
		int idx = 0;
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				arr[idx++] = i;
			}
		}

		int answer = 0;
		int sum = 0;
		int start = 0;
		int end = 0;

		while (true) {
			if (sum >= N) {
				sum -= arr[start++];
			} else if (end == idx) {
				break;
			} else {
				sum += arr[end++];
			}

			if (sum == N) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}