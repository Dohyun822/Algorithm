import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] liquids = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			liquids[i] = Integer.parseInt(st.nextToken());
		}

		int leftIdx = 0;
		int rightIdx = n - 1;
		int ans = Math.abs(liquids[leftIdx] + liquids[rightIdx]);
		int ansLeft = leftIdx;
		int ansRight = rightIdx;

		while (leftIdx < rightIdx) {
			int tmp = liquids[leftIdx] + liquids[rightIdx];

			if (Math.abs(tmp) < ans) {
				ansLeft = leftIdx;
				ansRight = rightIdx;
				ans = Math.abs(tmp);

				if (ans == 0)
					break;
			}

			if (tmp < 0) {
				leftIdx++;
			} else {
				rightIdx--;
			}
		}

		System.out.println(liquids[ansLeft] + " " + liquids[ansRight]);
	}
}
