import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hash = new HashMap<String, Integer>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String kind = st.nextToken();
				hash.put(kind, hash.getOrDefault(kind, 0) + 1);
			}
			int res = 1;
			for (int x : hash.values()) {
				res *= (x + 1);
			}
			sb.append(res - 1).append("\n");
		}
		System.out.println(sb.toString());
	}
}// end of class