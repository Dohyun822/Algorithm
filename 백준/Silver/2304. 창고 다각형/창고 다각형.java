import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Stick {
		int idx;
		int h;

		public Stick(int idx, int h) {
			this.idx = idx;
			this.h = h;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Stick> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Stick stick = new Stick(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			arr.add(stick);
		}
		Collections.sort(arr, (o1, o2) -> {
			return o1.idx - o2.idx;
		});

		int Maxhigh = 0;
		int Maxhigh_idx = 0;
		for (int i = 0; i < arr.size(); i++) { // 만약 제일 높은 기둥이 여러개면 맨 나중 기둥 인덱스 저장
			if (Maxhigh <= arr.get(i).h) {
				Maxhigh = arr.get(i).h;
				Maxhigh_idx = i;
			}
		}
		int answer = Maxhigh;
		// 왼쪽부터 가장 높은 기둥까지의 넓이
		Stick now = arr.get(0);
		for (int i = 1; i <= Maxhigh_idx; i++) {
			Stick right = arr.get(i);
			if (right.h >= now.h) {// 더 큰 기둥 만남
				answer += now.h * (right.idx - now.idx);
				now = right;
			}
		}

		// 오른쪽부터 가장 높은 기둥까지의 넓이
		now = arr.get(N - 1);
		for (int i = N - 2; i >= Maxhigh_idx; i--) {
			Stick left = arr.get(i);
			if (left.h >= now.h) {
				answer += now.h * (now.idx - left.idx);
				now = left;
			}
		}
		System.out.println(answer);

	}// end of main
}// end of class