import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	private static int[] arr;
	private static int cnt;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		arr = new int[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		answer = 1;

		while (true) {
			cnt = 0;
			for (int i = 0; i < 5; i++) {
				if (answer % arr[i] == 0) {
					cnt++;
				}
			}
			if (cnt >= 3) {
				break;
			}
			answer++;
		}
		System.out.println(answer);

	}// end of main
}// end of class