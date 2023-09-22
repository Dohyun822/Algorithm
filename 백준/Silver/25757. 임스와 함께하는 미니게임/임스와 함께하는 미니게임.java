import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		String gameType = st.nextToken();

		HashSet<String> uniqueNames = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			uniqueNames.add(name);
		}

		int uniqueCount = uniqueNames.size();

		int requiredPlayers = 0;
		if (gameType.equals("Y")) {
			requiredPlayers = 1;
		} else if (gameType.equals("F")) {
			requiredPlayers = 2;
		} else if (gameType.equals("O")) {
			requiredPlayers = 3;
		}

		int maxGames = uniqueCount / requiredPlayers;
		System.out.println(maxGames);
	}
}