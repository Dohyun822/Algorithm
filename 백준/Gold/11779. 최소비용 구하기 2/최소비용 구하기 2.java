import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

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

//	private static int N;
//	private static int M;
//	private static int start;
//	private static int end;
//	private static int[] distance;
//	private static int[] visitedList;
//
//	static ArrayList<Temp> temp[];
//	private static int visitCnt;
//	private static int tempMax;

	private static int N;
	private static int M;
	private static int[][] adjMatrix;
	private static int start;
	private static int end;
	private static int[] distance;
	private static boolean[] visited;
	private static int visitCnt;
	private static int[] visitedList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		StringBuilder city = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

//		temp = new ArrayList[N + 1];
//		for (int i = 0; i < N + 1; i++) {
//			temp[i] = new ArrayList<Temp>();
//		}
//
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int from = Integer.parseInt(st.nextToken());
//			int to = Integer.parseInt(st.nextToken());
//			int weight = Integer.parseInt(st.nextToken());
//			temp[from].add(new Temp(to, weight));
//		}

		adjMatrix = new int[N + 1][N + 1];
		for (int[] x : adjMatrix) {
			Arrays.fill(x, -1);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if (adjMatrix[from][to] == -1) {
				adjMatrix[from][to] = weight;
			} else {
				adjMatrix[from][to] = Math.min(weight, adjMatrix[from][to]);
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		final int INF = 999999999;
		distance = new int[N + 1];
		visitedList = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;

//		PriorityQueue<Temp> pq = new PriorityQueue<Temp>();
//		pq.add(new Temp(start, 0));
//		while (!pq.isEmpty()) {
//			Temp current = pq.poll();
//			for (Temp x : temp[current.vertex]) {
//				if (distance[x.vertex] > current.weight + x.weight) {
//					distance[x.vertex] = current.weight + x.weight;
//					pq.add(new Temp(x.vertex, distance[x.vertex]));
//					visitedList[x.vertex] = current.vertex;
//				}
//			}
//		}

		for (int i = 1; i <= N; i++) {
			int current = -1;
			int min = INF;

			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			if (current == -1) {
				break;
			}

			visited[current] = true;
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && adjMatrix[current][j] != -1 && distance[j] > min + adjMatrix[current][j]) {
					distance[j] = min + adjMatrix[current][j];
					visitedList[j] = current;
				}
			}
		}

		Stack<Integer> s = new Stack<Integer>();
		s.add(end);
		int index = end;
		while (visitedList[index] != start) {
			s.add(visitedList[index]);
			index = visitedList[index];
		}
		s.add(start);
		visitCnt = s.size();
		sb.append(distance[end]).append("\n").append(visitCnt).append("\n");
		while (!s.isEmpty()) {
			city.append(s.pop()).append(" ");
		}
		System.out.print(sb.toString());
		System.out.print(city.toString());
	}// end of main
}// end of class