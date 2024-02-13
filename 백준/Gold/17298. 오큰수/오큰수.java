import java.io.*;
import java.util.*;

public class Main {
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N];
		int[] answer = new int[N];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(answer, -1);

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				answer[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (Integer x : answer) {
			sb.append(x).append(" ");
		}
		System.out.println(sb.toString());
	}
}