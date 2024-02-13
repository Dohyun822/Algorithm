import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		int M = Integer.parseInt(br.readLine());

		LinkedList<String> list = new LinkedList<>();
		for (char c : s.toCharArray()) {
			list.add(String.valueOf(c));
		}

		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			it.next();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			String command = st.nextToken();

			switch (command) {
			case "L":
				if (it.hasPrevious()) {
					it.previous();
				}
				break;
			case "D":
				if (it.hasNext()) {
					it.next();
				}
				break;
			case "B":
				if (it.hasPrevious()) {
					it.previous();
					it.remove();
				}
				break;
			case "P":
				it.add(st.nextToken());
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str);
		}
		System.out.println(sb.toString());
	}
}
