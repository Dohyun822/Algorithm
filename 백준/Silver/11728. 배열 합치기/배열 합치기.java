import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] A;
	private static int[] B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N];
		B = new int[M];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);

		int selectA = 0;
		int selectB = 0;

		while (true) {
			if (selectB == M && selectA < N) {
				sb.append(A[selectA++]).append(" ");
			} else if (selectA == N && selectB < M) {
				sb.append(B[selectB++]).append(" ");
			} else if (A[selectA] >= B[selectB]) {
				sb.append(B[selectB++]).append(" ");
			} else if (A[selectA] < B[selectB]) {
				sb.append(A[selectA++]).append(" ");
			}
			if (selectB == M && selectA == N) {
				break;
			}

		}

		System.out.println(sb.toString());

	}
}