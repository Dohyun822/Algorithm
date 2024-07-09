import java.util.*;
import java.io.*;

public class Main {
    private static int[] dist;

    public static class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    private static int n;
    private static ArrayList<Node>[] graphs;

    public static void main(String[] ars) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        graphs = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<Node>();
        }


        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graphs[s].add(new Node(e, w));
            graphs[e].add(new Node(s, w));
        }
        dist = new int[n + 1];

        dfs(1, 0);

        int idx = 0;
        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (max < dist[i]) {
                max = dist[i];
                idx = i;
            }
        }

        Arrays.fill(dist, 0);
        dfs(idx, 0);

        max = 0;

        for (int i = 1; i <= n; i++) {
            if (max < dist[i]) {
                max = dist[i];
            }
        }

        System.out.println(max);

    }

    private static void dfs(int cur, int prev) {
        for (Node next : graphs[cur]) {
            if (next.vertex == prev) {
                continue;
            }
            dist[next.vertex] += dist[cur] + next.cost;
            dfs(next.vertex, cur);
        }
    }
}