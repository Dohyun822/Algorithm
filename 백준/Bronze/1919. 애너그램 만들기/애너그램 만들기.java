import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String e = br.readLine();

		int[] arr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < e.length(); i++) {
			arr[e.charAt(i) - 'a']--;
		}

		int answer = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				answer += Math.abs(arr[i]);
			}
		}

		System.out.println(answer);

	}
}
