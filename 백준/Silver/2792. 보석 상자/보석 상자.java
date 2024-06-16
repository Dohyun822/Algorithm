import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] jewel = new int[M];
		long total = 0;
		for (int i = 0; i < M; i++) {
			jewel[i] = Integer.parseInt(br.readLine());
			total += jewel[i];
		}

		long left = 1;
		long right = total;
		long result = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			if (solve(jewel, N, mid)) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(result);
	}

	public static boolean solve(int[] jewels, int N, long max) {
		long need = 0;

		for (int jewel : jewels) {
			need += (jewel + max - 1) / max;
			if (need > N) {
				return false;
			}
		}

		return need <= N;
	}
}
