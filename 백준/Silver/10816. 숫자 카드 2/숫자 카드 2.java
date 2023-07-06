import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int[] arr;
	private static int M;
	private static int[] arr2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		arr2 = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
			sb.append(findHighIndex(i) - findLowIndex(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static int findHighIndex(int i) {
		int start = 0;
		int end = N - 1;
		int cnt = 0;
		boolean chk = false;
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			if (arr2[i] == arr[mid]) {
				start = mid + 1;
				cnt = mid;
				chk = true;
			} else if (arr2[i] > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (chk) {
			cnt++;
		}
		return cnt;
	}

	private static int findLowIndex(int i) {
		int start = 0;
		int end = N - 1;
		int cnt = 0;

		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			if (arr2[i] == arr[mid]) {
				end = mid - 1;
				cnt = mid;
			} else if (arr2[i] > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return cnt;
	}

}