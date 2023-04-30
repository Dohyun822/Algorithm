import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int T;
	private static int n;
	private static String command;
	private static String arr;
	private static boolean reverse;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());

		ex: for (int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();
			command = br.readLine();

			n = Integer.parseInt(br.readLine());

			arr = br.readLine();

			arr = arr.substring(1, arr.length() - 1);

			st = new StringTokenizer(arr, ",");

			Deque<Integer> q = new ArrayDeque<Integer>();

			for (int i = 0; i < n; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			reverse = false;
			for (int i = 0; i < command.length(); i++) {
				switch (command.charAt(i)) {
				case 'R':
					reverse = !reverse;
					break;
				case 'D':
					if (q.size() == 0) {
						System.out.println("error");
						continue ex;
					} else if (reverse) {
						q.pollLast();
					} else {
						q.poll();
					}
					break;
				}
			}
			sb.append("[");
			if (reverse) {
				while (!q.isEmpty()) {
					sb.append(q.pollLast());
					if (q.size() != 0) {
						sb.append(",");
					}
				}
			} else {
				while (!q.isEmpty()) {
					sb.append(q.poll());
					if (q.size() != 0) {
						sb.append(",");
					}
				}
			}
			sb.append("]");

			System.out.println(sb.toString());
		}
	}// end of main
}// end of class