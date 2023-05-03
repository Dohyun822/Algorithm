import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = new ArrayDeque<Integer>();
		Queue<Integer> q2 = new ArrayDeque<Integer>();
		long hap1 = 0;
		long hap2 = 0;

		for (int i = 0; i < queue2.length; i++) {
			q1.offer(queue1[i]);
			q2.offer(queue2[i]);

			hap1 += queue1[i];
			hap2 += queue2[i];
		}

		if ((hap1 + hap2) % 2 == 1) {
			return -1;
		}

		int cnt = 0;
		while (true) {
			if (hap1 == hap2) {
				break;
			}
			cnt++;
			if (hap1 > hap2) {
				int temp = q1.poll();
				hap1 -= temp;
				hap2 += temp;
				q2.offer(temp);
			} else if (hap2 > hap1) {
				int temp = q2.poll();
				hap1 += temp;
				hap2 -= temp;
				q1.offer(temp);
			}
			if (cnt > queue1.length * 3) {
				return -1;
			}
		}

		return cnt;
	}
}