import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static char[] T;
	private static char[] P;
	private static int[] pi;
	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();

		int tLength = T.length;
		int pLength = P.length;

		pi = new int[pLength];
		for (int i = 1, j = 0; i < pLength; i++) {
			while (j > 0 && P[i] != P[j]) {
				j = pi[j - 1];
			}
			if (P[i] == P[j]) {
				pi[i] = ++j;
			} else {
				pi[i] = 0;
			}
		}

		cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0, j = 0; i < tLength; i++) {
			while (j > 0 && T[i] != P[j]) {
				j = pi[j - 1];
			}
			if (T[i] == P[j]) {
				if (j == pLength - 1) {
					cnt++;
					list.add(i - j + 1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}

		sb.append(cnt).append("\n");

		for (Integer integer : list) {
			sb.append(integer).append(" ");
		}

		System.out.println(sb.toString());
	}
}