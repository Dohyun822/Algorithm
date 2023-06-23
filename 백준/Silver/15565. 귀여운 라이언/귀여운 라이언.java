import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int K;
	private static int[] arr;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N]; // 배열 초기화
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int lionCnt = 0;
		answer = Integer.MAX_VALUE;

		while (end < N) {
			if (arr[end++] == 1) {
				lionCnt++;
			}

			while (lionCnt >= K) {
				answer = Math.min(answer, end - start); // 현재 길이와 answer를 비교해 최소값 갱신
				if (arr[start++] == 1) {
					lionCnt--;
				}
			}
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}