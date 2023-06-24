import java.io.*;
import java.util.*;

public class Main {
	private static int[] arr;
	private static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9];
		int hap = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			hap += arr[i];
		}

		Arrays.sort(arr);

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (hap - arr[i] - arr[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i || k == j) {
							continue;
						}
						System.out.println(arr[k]);
					}
					return;
				}
			}
		}
	}

}