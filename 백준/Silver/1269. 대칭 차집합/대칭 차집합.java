import java.io.*;
import java.util.*;

public class Main {
	private static int A;
	private static int B;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		answer = A + B;

		HashSet<Integer> arrA = new HashSet<>();
		HashSet<Integer> arrB = new HashSet<>();

		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			arrA.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			arrB.add(Integer.parseInt(st.nextToken()));
		}

		for (int a : arrA) {
			if (arrB.contains(a)) {
				answer -= 2;
			}
		}

		System.out.println(answer);

	}
}