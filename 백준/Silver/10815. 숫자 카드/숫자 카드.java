import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}

		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			if (map.get(Integer.parseInt(st.nextToken())) != null) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}

		System.out.println(sb.toString());

	}// end of main
}// end of class