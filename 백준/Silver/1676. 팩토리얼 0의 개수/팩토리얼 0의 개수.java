import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int answer;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		BigInteger temp = new BigInteger("2");
		for (int i = 3; i <= N; i++) {
			temp = temp.multiply((BigInteger.valueOf(i)));

		}
		int cnt = 0;
		String s = temp.toString();
		for (int i = s.length() - 1; i > 0; i--) {
			if (s.charAt(i) != '0') {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}// end of main
}// end of class