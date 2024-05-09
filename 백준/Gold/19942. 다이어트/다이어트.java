import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int mp;
	private static int mf;
	private static int ms;
	private static int mv;
	private static int[] p;
	private static int[] f;
	private static int[] s;
	private static int[] v;
	private static int[] c;
	private static ArrayList<Integer> answer;
	private static int minCost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		mp = Integer.parseInt(st.nextToken()); // 단
		mf = Integer.parseInt(st.nextToken()); // 지
		ms = Integer.parseInt(st.nextToken()); // 탄
		mv = Integer.parseInt(st.nextToken()); // 비

		p = new int[N];
		f = new int[N];
		s = new int[N];
		v = new int[N];
		c = new int[N];

		answer = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p[i] = Integer.parseInt(st.nextToken());
			f[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}

		minCost = Integer.MAX_VALUE;

		recur(0, 0, 0, 0, 0, 0, new ArrayList<>());

		if (answer.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(minCost);
			for (int x : answer) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	private static void recur(int cur, int np, int nf, int ns, int nv, int nc, ArrayList<Integer> list) {
		if (np >= mp && nf >= mf && ns >= ms && nv >= mv) {
			if (nc < minCost) {
				minCost = nc;
				answer = new ArrayList<>(list);
			}
		}

		if (cur == N) {
			return;
		}

		list.add(cur + 1);
		recur(cur + 1, np + p[cur], nf + f[cur], ns + s[cur], nv + v[cur], nc + c[cur], list);
		list.remove(list.size() - 1);
		recur(cur + 1, np, nf, ns, nv, nc, list);
	}

}