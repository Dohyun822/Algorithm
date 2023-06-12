import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			answer = 1;
			ArrayList<Integer> list = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(list);

			for (int j = 1; j < list.size(); j++) {
				for (int k = 0; k < list.size(); k++) {
					if (j == k) {
						continue;
					}
					int max = list.get(j);
					int b = list.get(k);
					while (max % b != 0) {
						int temp = max % b;
						max = b;
						b = temp;
					}
					if (answer < b) {
						answer = b;
					}
				}
			}

			System.out.println(answer);

		}

	}// end of main
}// end of class