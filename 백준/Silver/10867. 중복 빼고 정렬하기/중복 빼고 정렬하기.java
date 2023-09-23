import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		StringBuilder sb = new StringBuilder();
		sb.append(numbers[0]).append(' ');
		for (int i = 1; i < N; i++) {
			if (numbers[i] != numbers[i - 1]) {
				sb.append(numbers[i]).append(' ');
			}
		}
		System.out.println(sb.toString().trim());
	}
}