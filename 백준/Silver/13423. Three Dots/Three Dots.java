import java.io.*;
import java.util.*;

public class Main {
	private static int T;
	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 2; j < N; j++) {
					if ((arr[i] + arr[j]) % 2 == 0) {
						int dot = (arr[i] + arr[j]) / 2;
						count += checkDot(arr, dot);
					}
				}
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int checkDot(int[] arr, int dot) {
		int leftIndex = Arrays.binarySearch(arr, dot);
		if (leftIndex < 0) {
			return 0;
		}
		return 1;
	}
}