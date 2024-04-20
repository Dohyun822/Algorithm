import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			PriorityQueue<Long> pq = new PriorityQueue<Long>();

			while (st.hasMoreTokens()) {
				pq.add(Long.parseLong(st.nextToken()));
			}

			long answer = 0;

			while (pq.size() > 1) {
				long temp = pq.poll();
				long temp2 = pq.poll();
				long hap = temp + temp2;

				answer += hap;
				pq.add(hap);
			}

			System.out.println(answer);
		}
	}
}