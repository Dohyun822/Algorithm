import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int month = 1; month <= 12; month++) {
				for (int day = 1; day <= 31; day++) {
					if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
						continue;
					if (month == 2 && day > 29)
						continue;

					boolean valid = true;
					String date = Integer.toString(month) + Integer.toString(day);
					for (char c : date.toCharArray()) {
						if (arr[c - '0'] == 1) {
							valid = false;
							break;
						}
					}

					if (valid)
						cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}