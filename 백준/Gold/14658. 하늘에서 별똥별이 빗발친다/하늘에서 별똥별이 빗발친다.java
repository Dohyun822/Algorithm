import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, l, k;
	static ArrayList<int[]> v;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		v = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			v.add(new int[] { x, y });
		}

		int ans = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				ans = Math.max(ans, calc(v.get(i)[0], v.get(j)[1]));
			}
		}

		System.out.println(k - ans);
	}

	static int calc(int x, int y) {
		int res = 0;
		for (int i = 0; i < k; i++) {
			if (x <= v.get(i)[0] && v.get(i)[0] <= x + l && y <= v.get(i)[1] && v.get(i)[1] <= y + l) {
				res++;
			}
		}
		return res;
	}
}
