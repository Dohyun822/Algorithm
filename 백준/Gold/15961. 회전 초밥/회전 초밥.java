import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int C;
	private static int K;
	private static int D;
	private static int answer;
	private static int[] number;
	private static int temp;
	private static int cnt;
	private static int[] cycle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<Integer>();
		number = new int[D + 1];
		cycle = new int[N];
		answer = 1;
		temp = 1;
		cnt = 0;

		number[C]++;

		for (int i = 0; i < N; i++) {
			cycle[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N + K; i++) {

			int kind = cycle[i % N];
			list.add(kind);
			if (number[kind] == 0) {
				temp++;
			}
			number[kind]++;
			cnt++;

			if (cnt == K) {
				answer = answer > temp ? answer : temp;
				number[list.get(0)]--;
				if (number[list.get(0)] == 0) {
					temp--;
				}
				list.remove(0);
				cnt--;
			}
		}

		System.out.println(answer);

	}
}