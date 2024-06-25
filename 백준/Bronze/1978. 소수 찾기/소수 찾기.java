import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int answer = 0;

		boolean[] isPrime = new boolean[1001];
		for (int i = 2; i <= 1000; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= 1000; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 1000; j += i) {
					isPrime[j] = false;
				}
			}
		}

		while (st.hasMoreTokens()) {
			if (isPrime[Integer.parseInt(st.nextToken())]) {
				answer++;
			}
		}
		System.out.println(answer);

	}

}
