import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[] S;
	static int[] B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			
		}
		solve(0, 1, 0,-1);
		System.out.println(min);
		
	}// end of main
	public static void solve(int i, int s, int b, int idx) {
		
		if(i>0) {			
			min = Math.min(min,Math.abs(s-b));
		}
		
		for (int j = idx+1; j < N; j++) {
			solve(i+1, S[j]*s, B[j]+b, j);
		}
	}

	
}// end of class