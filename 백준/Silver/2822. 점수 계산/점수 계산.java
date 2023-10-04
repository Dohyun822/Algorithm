import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] scores = new int[8][2];

		for (int i = 0; i < 8; i++) {
			scores[i][0] = Integer.parseInt(br.readLine());
			scores[i][1] = i + 1;
		}

		Arrays.sort(scores, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});

		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += scores[i][0];
		}

		int[] selectedQuestions = new int[5];
		for (int i = 0; i < 5; i++) {
			selectedQuestions[i] = scores[i][1];
		}
		Arrays.sort(selectedQuestions);

		System.out.println(sum);
		for (int i = 0; i < 5; i++) {
			System.out.print(selectedQuestions[i] + " ");
		}
	}
}