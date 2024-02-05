import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(br.readLine());
		}

		int length = arr.get(0).length();
		for (int i = 1; i <= length; i++) {
			HashSet<String> check = new HashSet<>();
			for (String num : arr) {
				String sub = num.substring(num.length() - i);
				check.add(sub);
			}
			if (check.size() == N) {
				System.out.println(i);
				break;
			}
		}
	}
}