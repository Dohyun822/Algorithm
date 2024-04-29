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
		int F = Integer.parseInt(st.nextToken());

		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if (A * x + B * y == C && D * x + E * y == F) {
					System.out.println(x + " " + y);
					return;
				}
			}
		}

	}
}