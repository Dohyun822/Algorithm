import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int answer = 0;

		for (int i = 0; i <= K; i++) {
			int team = 0;
			int woman = N - i;
			int man = M - K + i;
			for (int j = 1; j <= man; j++) {
				if (woman - 2 >= 0) {
					team++;
					woman -= 2;
				}
			}
			answer = Math.max(answer, team);
		}

		System.out.println(answer);
	}
}