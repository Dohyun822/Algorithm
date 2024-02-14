import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			switch (width) {
			case 136:
				total += 1000;
				break;
			case 142:
				total += 5000;
				break;
			case 148:
				total += 10000;
				break;
			case 154:
				total += 50000;
				break;
			}
		}
		System.out.println(total);
	}
}
