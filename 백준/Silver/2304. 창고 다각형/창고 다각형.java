import java.io.*;
import java.util.*;

public class Main {
	static class Stick {
		int pos;
		int height;

		public Stick(int pos, int height) {
			this.pos = pos;
			this.height = height;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stick[] sticks = new Stick[N];

		int maxPos = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			sticks[i] = new Stick(pos, height);
			if (pos > maxPos) {
				maxPos = pos;
			}
		}

		Arrays.sort(sticks, (a, b) -> a.pos - b.pos);

		int[] heights = new int[maxPos + 1];
		for (Stick stick : sticks) {
			heights[stick.pos] = stick.height;
		}

		int[] leftMax = new int[maxPos + 1];
		int[] rightMax = new int[maxPos + 1];

		leftMax[0] = heights[0];
		for (int i = 1; i <= maxPos; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
		}

		rightMax[maxPos] = heights[maxPos];
		for (int i = maxPos - 1; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
		}

		int maxH = 0, maxIdx = 0;
		for (int i = 0; i <= maxPos; i++) {
			if (heights[i] > maxH) {
				maxH = heights[i];
				maxIdx = i;
			}
		}

		int area = 0;
		for (int i = 0; i <= maxIdx; i++) {
			area += leftMax[i];
		}
		for (int i = maxPos; i > maxIdx; i--) {
			area += rightMax[i];
		}

		System.out.println(area);
	}
}
