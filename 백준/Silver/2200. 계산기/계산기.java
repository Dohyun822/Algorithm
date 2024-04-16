import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 2;

		for (int i = 1; i < N; i++) {
			if (arr[i] == 0) {
				answer += 2;
			} else {
				answer += len(arr[i]) + 3;
			}
		}

		if (arr[N] != 0) {
			answer += len(arr[N]) + 1;
		}

		System.out.println(answer);
	}

	private static int len(int number) {
		return String.valueOf(number).length();
	}
}