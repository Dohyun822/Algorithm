import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = N - 1;
		int answer = 0;

		while (left + 1 < right) {
			answer = Math.max(answer, (right - left - 1) * Math.min(num[left], num[right]));
			if (num[left] < num[right]) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(answer);
	}
}