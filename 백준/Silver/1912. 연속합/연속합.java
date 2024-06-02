import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] prefixSum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
		}

		int maxSum = Integer.MIN_VALUE;
		int minPrefixSum = prefixSum[0];

		for (int i = 1; i <= N; i++) {
			maxSum = Math.max(maxSum, prefixSum[i] - minPrefixSum);
			minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);
		}

		System.out.println(maxSum);
	}
}
