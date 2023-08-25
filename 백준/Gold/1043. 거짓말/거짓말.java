import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		Set<Integer> truthSet = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		int numTruth = Integer.parseInt(st.nextToken());

		for (int i = 0; i < numTruth; i++) {
			int person = Integer.parseInt(st.nextToken());
			truthSet.add(person);
		}

		List<List<Integer>> parties = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int partySize = Integer.parseInt(st.nextToken());
			List<Integer> party = new ArrayList<>();

			int firstPerson = Integer.parseInt(st.nextToken());
			party.add(firstPerson);

			for (int j = 1; j < partySize; j++) {
				int nextPerson = Integer.parseInt(st.nextToken());
				party.add(nextPerson);
				union(firstPerson, nextPerson);
			}

			parties.add(party);
		}

		// Update truth set according to union-find result
		Set<Integer> newTruthSet = new HashSet<>();
		for (int truthPerson : truthSet) {
			int parentTruth = find(truthPerson);
			for (int i = 1; i <= N; i++) {
				if (find(i) == parentTruth) {
					newTruthSet.add(i);
				}
			}
		}

		truthSet = newTruthSet;

		int answer = 0;

		for (List<Integer> party : parties) {
			boolean canLie = true;

			for (int person : party) {
				if (truthSet.contains(person)) {
					canLie = false;
					break;
				}
			}

			if (canLie) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}