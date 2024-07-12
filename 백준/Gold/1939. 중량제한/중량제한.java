import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int M;
    private static ArrayList<Node>[] graphs;

    public static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(o.cost, this.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graphs = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graphs[A].add(new Node(B, C));
            graphs[B].add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        System.out.println(bfs(S, E));

    }

    private static int bfs(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        pq.add(new Node(start, Integer.MAX_VALUE));
        visited[start] = true;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            visited[current.vertex] = true;

            if (current.vertex == end) {
                return current.cost;
            }

            for (Node next : graphs[current.vertex]) {
                if (!visited[next.vertex]) {
                    pq.add(new Node(next.vertex, Math.min(current.cost, next.cost)));
                }
            }
        }

        return -1;
    }
}