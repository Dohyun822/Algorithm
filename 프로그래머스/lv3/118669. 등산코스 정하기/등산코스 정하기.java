import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	private static class Node {
		int v, weight; // 노드, 가중치

		Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}

	static List<List<Node>> graph;
	static boolean[] visit;
	static int[] dist;

	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		graph = new ArrayList<>();
		dist = new int[n + 1];
		visit = new boolean[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] path : paths) {
			int start = path[0];
			int end = path[1];
			int weight = path[2];

			graph.get(start).add(new Node(end, weight));
			graph.get(end).add(new Node(start, weight));

		}

		dijkstra(gates, summits);

		int mn = Integer.MAX_VALUE; // 산봉우리 번호
		int mw = Integer.MAX_VALUE; // 최솟값

		Arrays.sort(summits);

		for (int summit : summits) {
			if (dist[summit] < mw) {
				mn = summit;
				mw = dist[summit];
			}
		}
		return new int[] { mn, mw };
	}

	static void dijkstra(int[] gates, int[] summits) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		for (int gate : gates) {
			q.add(new Node(gate, 0));
			dist[gate] = 0;
		}

		List<Integer> summitList = new ArrayList<>();

		for (int summit : summits) {
			summitList.add(summit);
		}

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.weight > dist[now.v]) {
				continue;
			}

			if (summitList.contains(now.v)) {
				continue;
			}

			for (Node next : graph.get(now.v)) {
				int dis = Math.max(dist[now.v], next.weight);
				if (dist[next.v] > dis) {
					dist[next.v] = dis;
					q.add(new Node(next.v, dis));
				}
			}
		}
	}

}