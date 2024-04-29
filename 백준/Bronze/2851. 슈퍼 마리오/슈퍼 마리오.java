import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] scores = new int[10];
		for (int i = 0; i < 10; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}

		int currentSum = 0;
		int Sum = 0;
		for (int score : scores) {
			currentSum += score;
			if (Math.abs(100 - currentSum) < Math.abs(100 - Sum)
					|| (Math.abs(100 - currentSum) == Math.abs(100 - Sum) && currentSum > Sum)) {
				Sum = currentSum;
			}
		}

		System.out.println(Sum);
	}
}
