import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ex: for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char[] arr = new char[27];
			String s = st.nextToken();
			String e = st.nextToken();

			for (int j = 0; j < s.length(); j++) {
				arr[s.charAt(j) - 'a']++;
			}

			for (int j = 0; j < e.length(); j++) {
				arr[e.charAt(j) - 'a']--;
			}

			for (int j = 0; j < 26; j++) {
				if (arr[j] != 0) {
					System.out.println("Impossible");
					continue ex;
				}
			}

			System.out.println("Possible");
		}

	}
}