import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		long answer = 0;

		for (int i = 0; i < N; i++) {
			long current = arr[i] * (N - i);
			if (current > answer) {
				answer = current;
			}
		}

		System.out.println(answer);
	}
}