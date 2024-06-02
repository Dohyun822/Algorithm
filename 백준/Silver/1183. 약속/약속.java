import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[i] = A - B;
		}

		Arrays.sort(arr);

		if (N % 2 == 1) {
			System.out.println(1);
		} else {
			int leftMedian = arr[N / 2 - 1];
			int rightMedian = arr[N / 2];
			System.out.println(Math.abs(rightMedian - leftMedian) + 1);
		}
	}
}