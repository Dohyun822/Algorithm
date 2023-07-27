import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		tree = new int[N * 4];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		init(1, N, 1);

		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());

			if (type == 1) {
				int idx = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				update(1, N, 1, idx, val);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				sb.append(query(1, N, 1, left, right)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static int init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}

	static int query(int start, int end, int node, int left, int right) {
		if (left > end || right < start) {
			return Integer.MAX_VALUE;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return Math.min(query(start, mid, node * 2, left, right), query(mid + 1, end, node * 2 + 1, left, right));
	}

	static void update(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end) {
			return;
		}
		if (start == end) {
			tree[node] = val;
			return;
		}
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, val);
		update(mid + 1, end, node * 2 + 1, idx, val);
		tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
	}
}