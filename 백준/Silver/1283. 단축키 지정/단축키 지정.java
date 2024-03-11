import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] used = new boolean[256];

		for (int i = 0; i < N; i++) {
			String option = br.readLine();
			String[] words = option.split(" ");
			boolean assigned = false;

			for (int j = 0; j < words.length && !assigned; j++) {
				char firstChar = words[j].charAt(0);
				if (!used[Character.toLowerCase(firstChar)] && !used[Character.toUpperCase(firstChar)]) {
					used[Character.toLowerCase(firstChar)] = used[Character.toUpperCase(firstChar)] = true;
					words[j] = "[" + firstChar + "]" + words[j].substring(1);
					assigned = true;
				}
			}

			if (!assigned) {
				for (int j = 0; j < option.length() && !assigned; j++) {
					char ch = option.charAt(j);
					if (ch != ' ' && !used[Character.toLowerCase(ch)] && !used[Character.toUpperCase(ch)]) {
						used[Character.toLowerCase(ch)] = used[Character.toUpperCase(ch)] = true;
						option = option.substring(0, j) + "[" + ch + "]" + option.substring(j + 1);
						words = option.split(" ");
						assigned = true;
					}
				}
			}

			System.out.println(String.join(" ", words));
		}
	}
}