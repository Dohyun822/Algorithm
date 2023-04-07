import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.math.*;

public class Main {
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int su = 665;
		
		while(true) {
			String SU = String.valueOf(su);
			
			if(SU.contains("666")) {
				count++;
			}

			if(count == N) {
				System.out.println(su);
				break;
			}
			su++;
			
		}

	}
		
	
}

