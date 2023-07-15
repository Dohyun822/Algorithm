import java.io.*;
import java.util.*;

public class Main {
	private static int T;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				pq.offer(Long.parseLong(st.nextToken()));
			}
			
			long answer = 1;
			while(pq.size()>1) {
				long A = pq.poll();
				long B = pq.poll();
				long result = A*B;
				
				pq.offer(result);
				
				answer *= (result % 1_000_000_007); 
				answer %= 1_000_000_007;
				
			}
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}