import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] filenames = new String[N];

		for (int i = 0; i < N; i++) {
			filenames[i] = br.readLine();
		}

		StringBuilder pattern = new StringBuilder(filenames[0]);

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < pattern.length(); j++) {
				if (pattern.charAt(j) != filenames[i].charAt(j)) {
					pattern.setCharAt(j, '?');
				}
			}
		}

		System.out.println(pattern.toString());
	}
}