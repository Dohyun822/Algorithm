import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int a = 0;
		int b = 0;
		int c = 0;
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			a = i;
			for (int j = i + 2; j <= N; j++) {
				b = j;
				for (int k = 2; k <= N; k += 2) {
					c = k;
					if (a + b + c == N) {
						answer++;
					}
				}
			}

		}
		System.out.println(answer);
	}
}