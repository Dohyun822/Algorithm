import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[1000001];

		for (int i = 2; i < 1000001; i++) {
			arr[i] = i;
		}

		for (int i = 2; i < 1000001; i++) {
			if (arr[i] == 0) {
				continue;
			}
			for (int j = i * 2; j < 1000001; j += i) {
				arr[j] = 0;
			}
		}

		for (int i = 0; i < N; i++) {
			boolean chk = true;
			long S = Long.parseLong(br.readLine());
			for (int j = 2; j < 1000001; j++) {
				if (arr[j] != 0 && S % arr[j] == 0) {
					System.out.println("NO");
					chk = false;
					break;
				}
			}
			if (chk) {
				System.out.println("YES");
			}
		}
	}
}