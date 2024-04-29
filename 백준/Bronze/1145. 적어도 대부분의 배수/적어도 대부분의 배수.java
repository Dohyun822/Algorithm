import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			int chk = 0;
			if (i % A == 0) {
				chk++;
			}
			if (i % B == 0) {
				chk++;
			}
			if (i % C == 0) {
				chk++;
			}
			if (i % D == 0) {
				chk++;
			}
			if (i % E == 0) {
				chk++;
			}
			if (chk >= 3) {
				System.out.println(i);
				return;
			}
		}
	}
}
