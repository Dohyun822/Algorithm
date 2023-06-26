import java.io.*;
import java.util.*;

public class Main {

	private static int N;
	private static int M;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		for (int x = 0; x < M; x++) {
			st = new StringTokenizer(br.readLine(), " ");

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for (int y = i; y <= j; y++) {
				arr[y] = k;
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}