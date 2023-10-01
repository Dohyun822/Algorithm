import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String p = br.readLine();
		long t = 0;
		int a = (int) 'a';
		N--;

		for (char c : p.toCharArray()) {
			int d = (int) c - a;
			if (d > 0) {
				t += (long) (d * 26 * (Math.pow(26, N) - 1) / 25) + d;
			}
			t++;
			N--;
		}

		System.out.println(t);
	}
}