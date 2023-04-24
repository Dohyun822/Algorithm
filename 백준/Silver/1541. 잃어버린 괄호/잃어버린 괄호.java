import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		answer = -99999999;
		while (st.hasMoreTokens()) {
			StringTokenizer temp = new StringTokenizer(st.nextToken(), "+");

			int sum = 0;
			while (temp.hasMoreTokens()) {
				sum += Integer.parseInt(temp.nextToken());
			}

			if (answer == -99999999) {
				answer = sum;
			} else {
				answer -= sum;
			}
		}

		System.out.println(answer);
	}// end of main
}// end of class