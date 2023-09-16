import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = 1;

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			String[] names = new String[n];
			String[][] messages = new String[n][n - 1];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				names[i] = st.nextToken();
				for (int j = 0; j < n - 1; j++) {
					messages[i][j] = st.nextToken();
				}
			}

			sb.append("Group ").append(num++).append("\n");
			boolean foundNasty = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if ("N".equals(messages[i][j])) {
						int targetIndex = (i - j - 1 + n) % n;
						sb.append(names[targetIndex]).append(" was nasty about ").append(names[i]).append("\n");
						foundNasty = true;
					}
				}
			}

			if (!foundNasty) {
				sb.append("Nobody was nasty\n");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}