import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		s = br.readLine();

		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0;
		int maxLen = 0;

		for (int end = 0; end < s.length(); end++) {
			char ch = s.charAt(end);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			while (map.size() > N) {
				char startChar = s.charAt(start);
				map.put(startChar, map.get(startChar) - 1);
				if (map.get(startChar) == 0) {
					map.remove(startChar);
				}
				start++;
			}

			maxLen = Math.max(maxLen, end - start + 1);
		}

		System.out.println(maxLen);

	}
}