import java.io.*;
import java.util.*;

public class Main {
	private static int n, m, k;
	private static List<int[]> quests = new ArrayList<>();
	private static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] quest = new int[k];
			for (int j = 0; j < k; j++) {
				quest[j] = Integer.parseInt(st.nextToken());
			}
			quests.add(quest);
		}

		List<Integer> combination = new ArrayList<>();
		recur(combination, 1);
		System.out.println(max);
	}

	static void recur(List<Integer> currentSkills, int nextSkill) {
		if (currentSkills.size() == n) {
			int count = count(currentSkills);
			max = Math.max(max, count);
			return;
		}
		for (int i = nextSkill; i <= 2 * n; i++) {
			currentSkills.add(i);
			recur(currentSkills, i + 1);
			currentSkills.remove(currentSkills.size() - 1);
		}
	}

	static int count(List<Integer> currentSkills) {
		int count = 0;
		for (int[] quest : quests) {
			if (chk(currentSkills, quest)) {
				count++;
			}
		}
		return count;
	}

	static boolean chk(List<Integer> skillSet, int[] quest) {
		for (int skill : quest) {
			if (!skillSet.contains(skill)) {
				return false;
			}
		}
		return true;
	}
}