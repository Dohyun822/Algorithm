import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num;
		Node link;

		public Node(int num, Node link) {
			this.num = num;
			this.link = link;
		}

	}

	private static int N;
	private static int M;
	private static int K;
	private static Node[] build;
	private static int[] linkCnt;
	private static int[] built;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		build = new Node[N + 1];
		linkCnt = new int[N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			build[X] = new Node(Y, build[X]);
			linkCnt[Y]++;
		}

		built = new int[N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int status = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (status == 1) {
				if (linkCnt[num] > 0) {
					System.out.println("Lier!");
					return;
				} else {
					if (built[num] == 0) {
						for (Node temp = build[num]; temp != null; temp = temp.link) {
							--linkCnt[temp.num];
						}
					}
					++built[num];
				}
			} else {
				if (built[num] < 1) {
					System.out.println("Lier!");
					return;
				}
				if (built[num] == 1) {
					for (Node temp = build[num]; temp != null; temp = temp.link) {
						++linkCnt[temp.num];
					}
				}
				--built[num];
			}
		}

		System.out.println("King-God-Emperor");
	}
}