import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int C;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int left = 1; // 최소 거리
		int right = arr[N - 1] - arr[0]; // 최대 거리
		int result = 0;

		while (left <= right) {
			int mid = (left + right) / 2; // 중간 거리
			int lastInstalled = arr[0]; // 첫 번째 집에 공유기 설치
			int count = 1;

			// 공유기 설치
			for (int i = 1; i < N; i++) {
				if (arr[i] - lastInstalled >= mid) {
					lastInstalled = arr[i];
					count++;
				}
			}

			// 공유기 수 확인 및 거리 조정
			if (count >= C) {
				result = mid; // 가능한 거리 갱신
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(result);
	}
}