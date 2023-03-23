class Solution {
	private static int result;
	private static String s;
	private static int N;

	public int[] solution(long[] numbers) {
		int[] answer = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1L) {
				answer[i] = 1;
				continue;
			}
			s = Long.toBinaryString(numbers[i]);

			N = 2;
			while ((1 << N) - 1 < s.length()) {
				N++;
			}
			int len = s.length();
			for (int j = 0; j < (1 << N) - len - 1; j++) {
				s = "0" + s;
			}
			result = 1;
			solve((1 << N - 1) - 1, N);
			answer[i] = result;
		}
		return answer;
	}

	private static void solve(int Node, int level) {
		if (level == 1) {
			return;
		}
		int temp = 1 << (level - 1) - 1;

		int left = Node - temp;
		int right = Node + temp;
		if (s.charAt(Node) == '0' && chk(Node, left, right)) {
			result = 0;
			return;
		}
		solve(left, level - 1);
		solve(right, level - 1);
	}

	private static boolean chk(int idx, int left, int right) {
		if (s.charAt(left) == '1' || s.charAt(right) == '1') {
			return true;
		}
		return false;
	}
}