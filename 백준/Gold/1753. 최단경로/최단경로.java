import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

	static class Temp implements Comparable<Temp> {
		int vertex;
		int weight;

		public Temp(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Temp o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int V;
	static int E;
	static int K;
	static final int INF = Integer.MAX_VALUE;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Temp> temp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		temp = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			temp[i] = new ArrayList<Temp>();
		}
		distance = new int[V + 1];
		visited = new boolean[V + 1];
		Arrays.fill(distance, INF);
		distance[K] = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			temp[Integer.parseInt(st.nextToken())]
					.add(new Temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		PriorityQueue<Temp> pq = new PriorityQueue<Temp>();
		pq.add(new Temp(K, 0));
		while (!pq.isEmpty()) {
			Temp current = pq.poll();
			for (Temp x : temp[current.vertex]) {
				if (distance[x.vertex] > current.weight + x.weight) {
					distance[x.vertex] = current.weight + x.weight;
					pq.add(new Temp(x.vertex, distance[x.vertex]));
				}
			}
		}

		for (int i = 1; i < distance.length; i++) {
			sb.append(distance[i] != INF ? distance[i] : "INF").append("\n");
		}

		System.out.println(sb.toString());

	}// end of main
}// end of class