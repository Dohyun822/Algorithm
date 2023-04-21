import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int A;
	private static int B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add((int) (A * (-1) + Math.sqrt(A * A - B)));
		list.add((int) (A * (-1) - Math.sqrt(A * A - B)));

		if (list.get(0) == list.get(1)) {
			System.out.println(list.get(0));
		} else {
			Collections.sort(list);
			System.out.print(list.get(0) + " ");
			System.out.println(list.get(1));
		}

	}
}