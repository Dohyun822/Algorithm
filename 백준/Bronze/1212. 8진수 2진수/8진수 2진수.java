import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			int x = s.charAt(i) - '0';
			String t = Integer.toBinaryString(x);

			if (i == 0) {
				sb.append(t);
			} else {
				while (t.length() < 3) {
					t = "0" + t;
				}
				sb.append(t);
			}
		}

		System.out.println(sb.toString());
	}
}
