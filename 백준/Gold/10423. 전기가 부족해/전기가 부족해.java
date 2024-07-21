import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private static int[] parent;
    private static int[] rank;
    private static ArrayList<Node> graphs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int idx = Integer.parseInt(st.nextToken());
            list.add(idx);
            parent[idx] = idx;
        }

        graphs = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graphs.add(new Node(u, v, w));
        }

        Collections.sort(graphs);

        for (int i = 1; i < list.size(); i++) {
            union(list.get(0), list.get(i));
        }

        int answer = 0;
        for (Node node : graphs) {
            if (find(node.start) != find(node.end)) {
                answer += node.cost;
                union(node.start, node.end);
            }
        }

        System.out.println(answer);
    }

    private static void union(int start, int end) {
        int a = find(start);
        int b = find(end);

        if (a != b) {
            if (rank[a] > rank[b]) {
                parent[b] = a;
            } else if (rank[a] < rank[b]) {
                parent[a] = b;
            } else {
                parent[a] = b;
                rank[b]++;
            }
        }
    }

    private static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}