import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] minTree;
	private static int[] maxTree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		minTree = new int[N * 4]; // 최소값 트리
		maxTree = new int[N * 4]; // 최대값 트리

		minInit(1, 1, N);
		maxInit(1, 1, N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			int minVal = minFind(1, 1, N, left, right);
			int maxVal = maxFind(1, 1, N, left, right);

			sb.append(minVal).append(" ").append(maxVal).append("\n");

		}

		System.out.println(sb.toString());

	}

	// 범위 내 max값 찾기
	private static int maxFind(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return maxTree[node];
		}
		return Math.max(maxFind(node * 2, start, (start + end) / 2, left, right),
				maxFind(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}

	// 범위 내 min값 찾기
	private static int minFind(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return Integer.MAX_VALUE;
		}
		if (left <= start && end <= right) {
			return minTree[node];
		}
		return Math.min(minFind(node * 2, start, (start + end) / 2, left, right),
				minFind(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}

	// maxTree 초기화
	private static int maxInit(int node, int start, int end) {
		if (start == end) {
			return maxTree[node] = arr[start];
		} else {
			return maxTree[node] = Math.max(maxInit(node * 2, start, (start + end) / 2),
					maxInit(node * 2 + 1, (start + end) / 2 + 1, end));
		}
	}

	// minTree 초기화
	private static int minInit(int node, int start, int end) {
		if (start == end) {
			return minTree[node] = arr[start];
		} else {
			return minTree[node] = Math.min(minInit(node * 2, start, (start + end) / 2),
					minInit(node * 2 + 1, (start + end) / 2 + 1, end));
		}
	}

}