import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name = br.readLine();
		int N = Integer.parseInt(br.readLine());
		String answer = "";
		int result = -1;

		for (int i = 0; i < N; i++) {
			String team = br.readLine();
			int L = count(name + team, 'L');
			int O = count(name + team, 'O');
			int V = count(name + team, 'V');
			int E = count(name + team, 'E');

			int score = (((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100);

			if (score > result || (score == result && team.compareTo(answer) < 0)) {
				result = score;
				answer = team;
			}
		}

		System.out.println(answer);
	}

	private static int count(String s, char c) {
		int hap = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				hap++;
			}
		}
		return hap;
	}
}