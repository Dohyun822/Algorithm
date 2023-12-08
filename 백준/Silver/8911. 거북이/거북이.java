import java.io.*;
import java.util.*;

public class Main {

	private static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			String move = br.readLine();
			int[] point = { 0, 0 };
			int[] max = { 0, 0, 0, 0 };
			int direct = 0; // 0 1 2 3 북 동 남 서
			for (int j = 0; j < move.length(); j++) {
				switch (move.charAt(j)) {
				case 'F':
					if (direct == 0) {
						point[0]++;
						if (point[0] > max[0]) {
							max[0] = point[0];
						}
					} else if (direct == 1) {
						point[1]++;
						if (point[1] > max[1]) {
							max[1] = point[1];
						}

					} else if (direct == 2) {
						point[0]--;
						if (point[0] < max[2]) {
							max[2] = point[0];
						}
					} else if (direct == 3) {
						point[1]--;
						if (point[1] < max[3]) {
							max[3] = point[1];
						}
					}
					break;
				case 'B':
					if (direct == 0) {
						point[0]--;
						if (point[0] < max[2]) {
							max[2] = point[0];
						}
					} else if (direct == 1) {
						point[1]--;
						if (point[1] < max[3]) {
							max[3] = point[1];
						}

					} else if (direct == 2) {
						point[0]++;
						if (point[0] > max[0]) {
							max[0] = point[0];
						}
					} else if (direct == 3) {
						point[1]++;
						if (point[1] > max[1]) {
							max[1] = point[1];
						}
					}
					break;
				case 'L':
					direct--;
					if (direct < 0) {
						direct = 3;
					}
					break;
				case 'R':
					direct++;
					if (direct > 3) {
						direct = 0;
					}
					break;
				}
			}
			int answer = (max[0] - max[2]) * (max[1] - max[3]);
			sb.append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}
}