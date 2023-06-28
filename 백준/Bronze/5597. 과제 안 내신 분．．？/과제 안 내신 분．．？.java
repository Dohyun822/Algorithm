import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[31];

		for (int i = 0; i < 28; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 1; i < 31; i++) {
			if (arr[i] == 0) {
				System.out.println(i);
			}
		}
	}
}