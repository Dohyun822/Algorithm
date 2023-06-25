import java.io.*;
import java.util.*;

public class Main {

	private static int N;
	private static int v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		v = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			if(Integer.parseInt(st.nextToken())== v) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
	}
}