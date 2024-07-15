import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tree = new TreeMap<>();
			for (int j = 0; j < K; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String order = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				switch (order) {
				case "I":
					tree.put(n, tree.getOrDefault(n, 0) + 1);
					break;
				case "D":
					int num = 0;
					if (tree.size() == 0) {
						break;
					} else if (n == 1) {
						num = tree.lastKey();
					} else if (n == -1) {
						num = tree.firstKey();
					}
					if (tree.put(num, tree.get(num) - 1) == 1) {
						tree.remove(num);
					}
					break;
				}
			}
			if (tree.size() == 0) {
				System.out.println("EMPTY");
			} else {
				System.out.println(tree.lastKey() + " " + tree.firstKey());
			}
		}

	}
}