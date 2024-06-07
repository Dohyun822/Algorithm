import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		int sum = 0;
		int start = 0;

		for (int end = 0; end < N; end++) {
			sum += A[end];

			while (sum > M) {
				sum -= A[start++];
			}

			if (sum == M) {
				count++;
			}
		}

		System.out.println(count);
	}
}