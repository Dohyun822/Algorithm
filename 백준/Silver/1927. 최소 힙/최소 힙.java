import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			switch (temp) {
			case 0:
				if (pq.size() == 0) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
				break;

			default:
				pq.offer(temp);
				break;
			}
		}

		System.out.println(sb.toString());
	}// end of main
}// end of class