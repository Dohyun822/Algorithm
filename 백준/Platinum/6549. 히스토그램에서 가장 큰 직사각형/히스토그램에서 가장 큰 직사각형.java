import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static long[] height;
	private static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}

			height = new long[N];
			stack = new Stack<Integer>();

			for (int i = 0; i < N; i++) {
				height[i] = Long.parseLong(st.nextToken());
			}

			long answer = 0;

			for (int i = 0; i < N; i++) {
				while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
					long h = height[stack.pop()];
					long w = i;
					if (!stack.isEmpty()) {
						w = i - stack.peek() - 1;
					}
					answer = Math.max(answer, h * w);
				}
				stack.push(i);
			}

			while (!stack.isEmpty()) {
				long h = height[stack.pop()];
				long w = N;
				if (!stack.isEmpty()) {
					w = N - stack.peek() - 1;
				}
				answer = Math.max(answer, h * w);
			}

			sb.append(answer).append('\n');
		}

		System.out.print(sb.toString());
	}
}