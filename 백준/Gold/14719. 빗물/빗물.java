import java.io.*;
import java.util.*;

public class Main {

	private static int H;
	private static int W;
	private static int[] block;
	private static int[] leftMax;
	private static int[] rightMax;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		block = new int[W];
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}

		leftMax = new int[W];
		rightMax = new int[W];

		leftMax[0] = block[0];
		// 현재 위치에서의 왼쪽 최대 높이
		for (int i = 1; i < W; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], block[i]);
		}
		rightMax[W - 1] = block[W - 1];
		// 현재위치에서 오른쪽 최대 높이
		for (int i = W - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], block[i]);
		}

		answer = 0;

		for (int i = 0; i < W; i++) {
			answer += Math.min(leftMax[i], rightMax[i]) - block[i];

		}

		System.out.println(answer);
	}// end of main
}// end of class