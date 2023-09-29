import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] first = new int[N];
		int[] second = new int[N];

		int firstSum = 0;
		int secondSum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			first[i] = Integer.parseInt(st.nextToken());
			firstSum += Math.abs(first[i]);
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			second[i] = Integer.parseInt(st.nextToken());
			secondSum += Math.abs(second[i]);
		}

		System.out.println(firstSum + secondSum);
	}
}