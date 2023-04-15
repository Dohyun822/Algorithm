import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int idx;
		Node link;

		public Node(int idx, Node link) {
			this.idx = idx;
			this.link = link;
		}

	}

	private static int N;
	private static String[] name;
	private static HashMap map;
	private static Node[] list;
	private static int[] linkCnt;
	private static ArrayList<Integer>[] family;
	private static StringBuilder sb;
	private static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		name = new String[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			name[i] = st.nextToken();
		}
		Arrays.sort(name);

		map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			map.put(name[i], i);
		}

		list = new Node[N];
		linkCnt = new int[N];

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int X = (int) map.get(st.nextToken());
			int Y = (int) map.get(st.nextToken());
			list[Y] = new Node(X, list[Y]);
			linkCnt[X]++;
		}

		solve();

		System.out.println(sb.toString());

	}// end of main

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		ArrayList<Integer> root = new ArrayList<Integer>();
		family = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			family[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N; i++) {
			if (linkCnt[i] == 0) {
				root.add(i);
				q.offer(i);
			}
		}
		Collections.sort(root);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Node temp = list[cur]; temp != null; temp = temp.link) {
				if (--linkCnt[temp.idx] == 0) {
					family[cur].add(temp.idx);
					q.offer(temp.idx);
				}
			}
		}

		sb.append(root.size()).append("\n");
		for (Integer x : root) {
			sb.append(name[x]).append(" ");
		}
		sb.append("\n");
		for (int i = 0; i < N; i++) {
			sb.append(name[i]).append(" ").append(family[i].size()).append(" ");
			Collections.sort(family[i]);
			for (int j = 0; j < family[i].size(); j++) {
				sb.append(name[family[i].get(j)]).append(" ");
			}
			sb.append("\n");
		}
	}
}// end of class