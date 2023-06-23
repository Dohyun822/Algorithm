import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int K;
	private static int[] nameLen;
	private static String[] name;
	private static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		name = new String[N + 1];
		nameLen = new int[21];

		answer = 0;

		for (int i = 1; i <= N; i++) {
			name[i] = br.readLine();
		}

		for (int i = 1; i <= N; i++) {
			int len = name[i].length();
			if (i > K + 1) {
				nameLen[name[i - K - 1].length()]--;
			}

			answer += nameLen[len];
			nameLen[len]++;
		}

		System.out.println(answer);

	}
}