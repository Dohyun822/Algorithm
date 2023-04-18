import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static int M;
	private static HashMap<Integer, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		map = new HashMap<Integer, Integer>();

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "add":
				map.put(Integer.parseInt(st.nextToken()), 1);
				break;
			case "remove":
				map.remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				sb.append(map.get(Integer.parseInt(st.nextToken())) != null ? 1 : 0).append("\n");
				break;
			case "toggle":
				int temp = Integer.parseInt(st.nextToken());
				if (map.get(temp) == null) {
					map.put(temp, 1);
				} else {
					map.remove(temp);
				}
				break;
			case "all":
				for (int j = 1; j <= 20; j++) {
					if (!map.containsKey(j))
						map.put(j, 1);
				}
				break;
			case "empty":
				map.clear();
				break;
			}
		}
		System.out.println(sb.toString());
	}// end of main
}// end of class