import java.io.*;
import java.util.*;

public class Main {
	private static int n;
	private static int[] prefix_Maxsum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		prefix_Maxsum = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		prefix_Maxsum[1] = Integer.parseInt(st.nextToken());

		int answer = prefix_Maxsum[1];

		for (int i = 2; i <= n; i++) {
			int next = Integer.parseInt(st.nextToken());
			prefix_Maxsum[i] = Math.max(next, prefix_Maxsum[i - 1] + next);

			if (prefix_Maxsum[i] > answer) {
				answer = prefix_Maxsum[i];
			}
		}

		System.out.println(answer);

	}
}