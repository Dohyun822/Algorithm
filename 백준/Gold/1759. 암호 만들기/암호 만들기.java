import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int L;
	static int C;
	static char[] arr;
	static boolean[] isSelected;
	static char[] S;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		S = new char[L];
		isSelected = new boolean[L];
		arr = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));

		sovle(0, 0);
		System.out.println(sb.toString());

	}

	private static void sovle(int index, int start) {
		if (index == L) {
			if (chk(S)) {
				for (int i = 0; i < S.length; i++) {
					sb.append(S[i]);
				}
				sb.append("\n");
			}

			return;
		}
		for (int i = start; i < C; i++) {
			S[index] = arr[i];
			sovle(index + 1, i + 1);

		}

	}

	private static boolean chk(char[] s) {
		int cnt = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == 'a' || s[i] == 'e' || s[i] == 'o' || s[i] == 'i' || s[i] == 'u') {
				cnt++;
			}
		}
		if (cnt < 1 || s.length - cnt < 2) {
			return false;
		}
		return true;
	}

}// end of class