import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] visitor = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			visitor[i] = Integer.parseInt(st.nextToken());
		}

		int[] prefixSum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + visitor[i];
		}

		int maxVisitor = Integer.MIN_VALUE;
		int maxCount = 0;

		for (int i = X; i <= N; i++) {
			int currentVisitors = prefixSum[i] - prefixSum[i - X];
			if (currentVisitors > maxVisitor) {
				maxVisitor = currentVisitors;
				maxCount = 1;
			} else if (currentVisitors == maxVisitor) {
				maxCount++;
			}
		}

		if (maxVisitor == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(maxVisitor);
			System.out.println(maxCount);
		}
	}
}