import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String king = st.nextToken();
		String stone = st.nextToken();
		int N = Integer.parseInt(st.nextToken());

		Map<String, int[]> move = new HashMap<>();
		move.put("R", new int[] { 0, 1 });
		move.put("L", new int[] { 0, -1 });
		move.put("B", new int[] { 1, 0 });
		move.put("T", new int[] { -1, 0 });
		move.put("RT", new int[] { -1, 1 });
		move.put("LT", new int[] { -1, -1 });
		move.put("RB", new int[] { 1, 1 });
		move.put("LB", new int[] { 1, -1 });

		String chess = "ABCDEFGH";
		int k1 = 8 - Character.getNumericValue(king.charAt(1));
		int k2 = chess.indexOf(king.charAt(0));
		int s1 = 8 - Character.getNumericValue(stone.charAt(1));
		int s2 = chess.indexOf(stone.charAt(0));

		for (int i = 0; i < N; i++) {
			String direction = br.readLine();
			int a = move.get(direction)[0];
			int b = move.get(direction)[1];

			if (0 <= k1 + a && k1 + a < 8 && 0 <= k2 + b && k2 + b < 8) {
				k1 += a;
				k2 += b;

				if (k1 == s1 && k2 == s2) {
					s1 += a;
					s2 += b;
				}
			}

			if (s1 < 0 || s1 >= 8 || s2 < 0 || s2 >= 8) {
				k1 -= a;
				k2 -= b;
				s1 -= a;
				s2 -= b;
			}
		}

		System.out.println(chess.charAt(k2) + "" + (8 - k1));
		System.out.println(chess.charAt(s2) + "" + (8 - s1));
	}
}