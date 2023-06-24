import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int[] arr;
	private static int x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		x = Integer.parseInt(br.readLine());

		int start = 0;
		int end = n - 1;

		int answer = 0;

		while (start < end) {
			if (arr[start] + arr[end] == x) {
				answer++;
				start++;
				end--;
			} else if (arr[start] + arr[end] < x) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println(answer);

	}
}