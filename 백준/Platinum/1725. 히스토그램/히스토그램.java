import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] height;
	private static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		height = new int[N];
		stack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
				int h = height[stack.pop()];
				int w = i;

				if (!stack.isEmpty()) {
					w = i - stack.peek() - 1;
				}

				answer = Math.max(answer, h * w);
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int h = height[stack.pop()];
			int w = N;

			if (!stack.isEmpty()) {
				w = N - stack.peek() - 1;
			}

			answer = Math.max(answer, h * w);
		}

		System.out.println(answer);

	}

}