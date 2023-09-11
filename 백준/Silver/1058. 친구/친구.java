import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] friends = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				if (row.charAt(j) == 'Y') {
					friends[i][j] = true;
				}
			}
		}

		int maxTwoFriends = 0;

		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (friends[i][j]) {
					count++;
					for (int k = 0; k < N; k++) {
						if (j == k || i == k)
							continue;
						if (friends[j][k]) {
							count++;
						}
					}
				}
			}

			boolean[] uniqueTwoFriends = new boolean[N];
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (friends[i][j]) {
					uniqueTwoFriends[j] = true;
					for (int k = 0; k < N; k++) {
						if (j == k || i == k)
							continue;
						if (friends[j][k]) {
							uniqueTwoFriends[k] = true;
						}
					}
				}
			}

			int uniqueCount = 0;
			for (boolean isTwoFriend : uniqueTwoFriends) {
				if (isTwoFriend) {
					uniqueCount++;
				}
			}

			maxTwoFriends = Math.max(maxTwoFriends, uniqueCount);
		}

		System.out.println(maxTwoFriends);
	}
}