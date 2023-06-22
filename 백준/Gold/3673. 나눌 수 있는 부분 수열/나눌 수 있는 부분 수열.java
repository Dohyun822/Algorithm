import java.io.*;
import java.util.*;

public class Main {
	private static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());

		for (int i = 0; i < c; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int[] prefix_Sum = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				prefix_Sum[j] = (prefix_Sum[j - 1] + Integer.parseInt(st.nextToken())) % d;
			}

			long result = 0;
			int[] count = new int[d];
			for (int j = 1; j <= n; j++) {
				if (prefix_Sum[j] == 0) {
					result++;
				}
				result += count[prefix_Sum[j]];
				count[prefix_Sum[j]]++;
			}
			System.out.println(result);
		}
	}
}