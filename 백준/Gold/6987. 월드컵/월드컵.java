import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int win[] = new int[6];
	static int draw[] = new int[6];
	static int lose[] = new int[6];
	static StringBuilder sb = new StringBuilder();
	static boolean chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ct: for (int i = 0; i < 4; i++) {
			chk = false;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
				if (win[j] + draw[j] + lose[j] != 5) {
					sb.append(0).append(" ");
					continue ct;
				}
			}
			int drawCnt = 0;
			for (int j = 0; j < 6; j++) {
				drawCnt += draw[j];
			}
			if (drawCnt % 2 != 0) {
				sb.append(0).append(" ");
				continue;
			}
			solve(0, 1, 0);
			if (chk) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb.toString());
	}// end of main

	private static void solve(int home, int away, int cnt) {
		if (win[home] < 0 || draw[home] < 0 || lose[home] < 0 || win[away - 1] < 0 || draw[away - 1] < 0
				|| lose[away - 1] < 0) {
			return;
		}
		if (cnt == 15) {
			chk = true;
			return;
		}

		if (cnt == 5 || cnt == 9 || cnt == 12 || cnt == 14) {
			home++;
			away = home + 1;
		}
		// 홈팀 승 (왼쪽)
		win[home]--;
		lose[away]--;
		solve(home, away + 1, cnt + 1);
		win[home]++;
		lose[away]++;
		// 무승부
		draw[home]--;
		draw[away]--;
		solve(home, away + 1, cnt + 1);
		draw[home]++;
		draw[away]++;
		// 어웨이 승 (오른쪽)
		win[away]--;
		lose[home]--;
		solve(home, away + 1, cnt + 1);
		win[away]++;
		lose[home]++;
	}
}// end of class