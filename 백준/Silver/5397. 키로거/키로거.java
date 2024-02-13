import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String command = br.readLine();

			LinkedList<Character> arr = new LinkedList<Character>();
			ListIterator<Character> it = arr.listIterator();

			for (char c : command.toCharArray()) {
				switch (c) {
				case '<':
					if (it.hasPrevious()) {
						it.previous();
					}
					break;
				case '>':
					if (it.hasNext()) {
						it.next();
					}
					break;
				case '-':
					if (it.hasPrevious()) {
						it.previous();
						it.remove();
					}
					break;
				default:
					it.add(c);
					break;
				}
			}

			StringBuilder sb = new StringBuilder();
			for (char c : arr) {
				sb.append(c);
			}
			System.out.println(sb.toString());

		}

	}
}
