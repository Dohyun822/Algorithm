import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int A = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int cnt = 0;
		for(int a = 0; a<A; a++ ) {
			int x = Integer.parseInt(st.nextToken());

			if(x==1) {
				continue;
			}
			int yak = 0;
			for(int i = 1; i<x;i++) {

				if(x%i==0) {
					yak++;
				}

			}
			if(yak == 1) {
				cnt++;
			}

		}
		System.out.println(cnt);

	}

}
