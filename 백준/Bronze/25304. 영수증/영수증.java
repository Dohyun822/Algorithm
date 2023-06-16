import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long X = Long.parseLong(br.readLine());
		int N = Integer.parseInt(br.readLine());
		long answer = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			answer += a * b;
		}

		if (answer == X) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}