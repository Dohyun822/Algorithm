import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] a = new int[w];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < w; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int[] left = new int[w];
		int[] right = new int[w];

		left[0] = a[0];
		for (int i = 1; i < w; i++) {
			left[i] = Math.max(left[i - 1], a[i]);
		}

		right[w - 1] = a[w - 1];
		for (int i = w - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], a[i]);
		}

		int answer = 0;
		for (int i = 0; i < w; i++) {
			int hight = Math.min(left[i], right[i]) - a[i];
			if (hight > 0) {
				answer += hight;
			}
		}

		System.out.println(answer);
	}
}
