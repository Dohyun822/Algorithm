import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Set<String> color = new HashSet<>();

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				color.add(st.nextToken());
			}
		}

		List<String> colorList = new ArrayList<>(color);
		Collections.sort(colorList);

		for (String i : colorList) {
			for (String j : colorList) {
				sb.append(i).append(" ").append(j).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}