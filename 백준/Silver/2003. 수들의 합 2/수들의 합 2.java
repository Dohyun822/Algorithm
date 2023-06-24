import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static long M;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;

		int answer = 0;
		while (end < N) {
			long hap = 0;
			for (int i = start; i <= end; i++) {
				hap += arr[i];
			}

			if (hap == M) {
				answer++;
				end++;
			} else if (hap < M) {
				end++;
			} else {
				start++;
			}
		}

		System.out.println(answer);

	}
}