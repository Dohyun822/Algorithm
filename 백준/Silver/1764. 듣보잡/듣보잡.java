import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb;
	private static int N;
	private static int M;
	private static ArrayList<String> answer;
	private static HashMap<String, Integer> list1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		answer = new ArrayList<String>();

		list1 = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			list1.put(br.readLine(), 0);
		}

		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (list1.get(temp) != null) {
				answer.add(temp);
			}
		}

		Collections.sort(answer);

		sb.append(answer.size()).append("\n");
		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i)).append("\n");
		}

		System.out.println(sb.toString());
	}// end of main
}// end of class