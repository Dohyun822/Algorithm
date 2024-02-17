import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		double expectedValue = 0.0;

		for (int i = 1; i <= N; i++) {
			expectedValue += (double) N / i;
		}

		System.out.printf("%.12f", expectedValue);
	}
}