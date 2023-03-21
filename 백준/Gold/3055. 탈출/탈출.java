import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R;
	private static int C;
	private static int answer;
	private static char[][] map;
	private static Queue<int[]> SQ = new ArrayDeque<int[]>();
	private static Queue<int[]> WQ = new ArrayDeque<int[]>();

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		answer = 2501;

		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				char input = s.charAt(c);
				map[r][c] = input; // 입력받기
				if (input == 'S') {
					SQ.offer(new int[] { r, c, 0 }); // 고슴도치 이동을 위한 큐
				} else if (input == '*') {
					WQ.offer(new int[] { r, c }); // 물을 퍼트리기 위한 큐
				}
			}
		}
		// 입력 끝

		bfs();
		System.out.println(answer == 2501 ? "KAKTUS" : answer);
	}// end of main

	private static void bfs() {
		while (!SQ.isEmpty()) {
			int waterCnt = WQ.size(); // 한 타임씩 퍼트리기 위해
			for (int i = 0; i < waterCnt; i++) {
				int temp[] = WQ.poll();
				for (int j = 0; j < 4; j++) {
					int nr = temp[0] + dr[j];
					int nc = temp[1] + dc[j];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {// 물이 차오를 수 있는 곳
						map[nr][nc] = '*';
						WQ.offer(new int[] { nr, nc });
					}
				}
			}
			int sCnt = SQ.size(); // 한 타임씩 움직이기 위해
			for (int i = 0; i < sCnt; i++) {
				int temp[] = SQ.poll();
				for (int j = 0; j < 4; j++) {
					int nr = temp[0] + dr[j];
					int nc = temp[1] + dc[j];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
						if (map[nr][nc] == '.') { // 갈 수 있는 곳
							map[nr][nc] = 'S';
							SQ.offer(new int[] { nr, nc, temp[2] + 1 });
						} else if (map[nr][nc] == 'D') { // 도착지
							answer = Math.min(answer, temp[2] + 1);
							return;
						}
					}
				}
			}

		}
	}
}// end of class