import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());

		int x = (N / 100) * 100;

		int result = 0;
		for (int i = 0; i < 100; i++) {
			if ((x + i) % F == 0) {
				result = i;
				break;
			}
		}

		if (result < 10) {
			System.out.println("0" + result);
		} else {
			System.out.println(result);
		}
	}
}
