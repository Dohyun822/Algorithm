import java.io.*;
import java.util.*;

public class Main {
	static int[] score = new int[1000001];
	static int[] card = new int[1000001];
	static List<Integer> number = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		while (st.hasMoreTokens()) {
			int temp = Integer.parseInt(st.nextToken());
			number.add(temp);
			card[temp] = 1;
		}

		for (int i = 0; i < N; i++) {
			int num = number.get(i);
			for (int j = num * 2; j <= 1000000; j += num) {
				if (card[j] == 1) {
					score[num]++;
					score[j]--;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(score[number.get(i)] + " ");
		}
	}
}