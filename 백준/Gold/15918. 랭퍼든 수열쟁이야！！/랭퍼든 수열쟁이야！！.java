import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int n, x, y, count = 0;
	static int[] sequence;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		x = Integer.parseInt(inputs[1]) - 1;
		y = Integer.parseInt(inputs[2]) - 1;
		sequence = new int[2 * n];
		used = new boolean[n + 1];

		int value = y - x - 1;
		if (value > 0 && value <= n) {
			sequence[x] = value;
			sequence[y] = value;
			used[value] = true;
			solve(0);
			sequence[x] = 0;
			sequence[y] = 0;
			used[value] = false;
		}

		System.out.println(count);
	}

	static void solve(int position) {
		if (position == 2 * n) {
			count++;
			return;
		}

		if (sequence[position] != 0) {
			solve(position + 1);
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!used[i] && position + i + 1 < 2 * n && sequence[position + i + 1] == 0) {
				sequence[position] = i;
				sequence[position + i + 1] = i;
				used[i] = true;

				solve(position + 1);

				sequence[position] = 0;
				sequence[position + i + 1] = 0;
				used[i] = false;
			}
		}
	}
}