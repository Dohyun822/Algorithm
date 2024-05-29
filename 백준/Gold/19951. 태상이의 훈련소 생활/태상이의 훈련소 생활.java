import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] order = new int[N + 2];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			order[a] += k;
			if (b + 1 <= N) {
				order[b + 1] -= k;
			}
		}

		for (int i = 1; i <= N; i++) {
			order[i] += order[i - 1];
		}

		for (int i = 1; i <= N; i++) {
			arr[i] += order[i];
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}