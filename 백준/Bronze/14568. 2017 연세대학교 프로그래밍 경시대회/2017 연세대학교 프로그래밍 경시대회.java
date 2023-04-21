import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		answer = 0;

		for (int i = 2; i <= N; i += 2) {
			if (N - i < 4) {
				break;
			}
			for (int j = 1; j <= N - i; j++) {
				int k = N - i - j;
				if (k >= 1 && k - j >= 2) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}