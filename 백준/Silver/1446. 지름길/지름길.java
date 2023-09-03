import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Shortcut implements Comparable<Shortcut> {
		int start;
		int end;
		int len;

		public Shortcut(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}

		@Override
		public int compareTo(Shortcut o) {
			return Integer.compare(this.start, o.start);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		PriorityQueue<Shortcut> shortcuts = new PriorityQueue<>();
		int maxEnd = D;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			shortcuts.add(new Shortcut(start, end, len));
			maxEnd = Math.max(maxEnd, end);
		}

		int[] distance = new int[maxEnd + 1];
		for (int i = 1; i <= maxEnd; ++i) {
			distance[i] = i;
		}

		for (int i = 0; i <= D; ++i) {
			while (!shortcuts.isEmpty() && shortcuts.peek().start == i) {
				Shortcut shortcut = shortcuts.poll();
				distance[shortcut.end] = Math.min(distance[shortcut.end], distance[i] + shortcut.len);
			}
			for (int j = i + 1; j <= D; ++j) {
				distance[j] = Math.min(distance[j], distance[i] + (j - i));
			}
		}

		System.out.println(distance[D]);
	}
}
