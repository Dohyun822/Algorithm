import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class shark {
		int r, c, s, d, z;
		private boolean reverse;

		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		public void move() {
			int originR = r;
			int originC = c;
			switch (d) {
			case 1:
				reverse = false;
				if (r == 1) {
					reverse = true;
					d = 2;
				}
				for (int i = 0; i < s; i++) {
					if (!reverse) {
						this.r = r - 1;
						if (r == 1 || r == R - 1) {
							reverse = true;
							this.d = 2;
						}
					} else {
						this.r = r + 1;
						if (r == 1 || r == R - 1) {
							reverse = false;
							this.d = 1;
						}
					}
				}
				break;
			case 2:
				reverse = false;
				if (r == R - 1) {
					reverse = true;
					d = 1;
				}
				for (int i = 0; i < s; i++) {
					if (!reverse) {
						this.r = r + 1;
						if (r == 1 || r == R - 1) {
							reverse = true;
							this.d = 1;
						}
					} else {
						this.r = r - 1;
						if (r == 1 || r == R - 1) {
							reverse = false;
							this.d = 2;
						}
					}
				}
				break;
			case 3:
				reverse = false;
				if (c == C - 1) {
					reverse = true;
					d = 4;
				}
				for (int i = 0; i < s; i++) {
					if (!reverse) {
						this.c = c + 1;
						if (c == 1 || c == C - 1) {
							reverse = true;
							this.d = 4;
						}
					} else {
						this.c = c - 1;
						if (c == 1 || c == C - 1) {
							reverse = false;
							this.d = 3;
						}
					}
				}
				break;
			case 4:
				reverse = false;
				if (c == 1) {
					reverse = true;
					d = 3;
				}
				for (int i = 0; i < s; i++) {
					if (!reverse) {
						this.c = c - 1;
						if (c == 1 || c == C - 1) {
							reverse = true;
							this.d = 3;
						}
					} else {
						this.c = c + 1;
						if (c == 1 || c == C - 1) {
							reverse = false;
							this.d = 4;
						}
					}
				}
				break;
			} // end of switch
			if (arrCopy[r][c] == null) {
				arrCopy[r][c] = arr[originR][originC];
			} else { // 잡아먹기
				if (arrCopy[r][c].z < arr[originR][originC].z)
					arrCopy[r][c] = arr[originR][originC];
			}
		} // end of move

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int r, c, m;
	private static shark[][] arr;
	private static int R;
	private static int C;
	private static int answer;
	private static shark[][] arrCopy;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()) + 1;
		C = Integer.parseInt(st.nextToken()) + 1;
		m = Integer.parseInt(st.nextToken());

		arr = new shark[R][C]; // 0은 안씀

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr[r][c] = new shark(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		} // input end

		for (int i = 1; i < C; i++) {
			for (int j = 1; j < R; j++) {
				if (arr[j][i] != null) {
					answer += arr[j][i].z;
					arr[j][i] = null;
					break;
				}
			} // 낚시왕 잡기

			arrCopy = new shark[R][C];
			for (int row = 1; row < R; row++) {
				for (int column = 1; column < C; column++) {
					if (arr[row][column] != null) { // 상어가 있다면
						arr[row][column].move();
					}
				}
			} // 상어 이동

			arr = arrCopy;
		} // 이동완료

		System.out.println(answer);

	} // end of main
} // end of class