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

		for (int i = 1; i <= 500; i++) {
			if (i * i + N <= 250000) {
				double temp = Math.sqrt(i * i + N);
				if ((int) temp * temp == i * i + N)
					answer++;
			}
		}
		System.out.println(answer);
	}
}