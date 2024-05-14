import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] capacities = new int[N];
		int[] sizes = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			capacities[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < M; j++) {
			sizes[j] = Integer.parseInt(st.nextToken());
		}

		int box = 0;
		int capacity = capacities[box];
		int total = 0;

		for (int j = 0; j < M; j++) {
			int bookSize = sizes[j];

			while (capacity < bookSize) {
				total += capacity;
				box++;
				capacity = capacities[box];
			}

			capacity -= bookSize;
			if (j == M - 1 || capacity == 0) {
				total += capacity;
				box++;
				if (box < N)
					capacity = capacities[box];
			}
		}

		while (box < N) {
			total += capacities[box++];
		}

		System.out.println(total);
	}
}
