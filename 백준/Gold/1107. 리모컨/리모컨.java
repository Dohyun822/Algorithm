import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static ArrayList<Integer> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new ArrayList<Integer>();
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
		}

		if (N == 100) {
			System.out.println(0);
			return;
		} else if (N == 0 && !arr.contains(0)) {
			System.out.println(1);
			return;
		}
		int answer = Math.abs(N - 100);
		for (int i = 0; i <= 999999; i++) {
			String temp = String.valueOf(i);
			boolean chk = true;
			for (int j = 0; j < temp.length(); j++) {
				if (arr.contains(temp.charAt(j) - '0')) {
					chk = false;
					break;
				}
			}
			if (chk) {
				int cnt = Math.abs(i - N);
				answer = Math.min(answer, temp.length() + cnt);
			}

		}
		System.out.println(answer);

	}// end of main
}// end of class