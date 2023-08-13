import java.io.*;
import java.util.*;

public class Main {
    static List<Pair>[] tree;
    static int[] distance;
    static boolean[] visited;

    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[a].add(new Pair(b, w));
            tree[b].add(new Pair(a, w));
        }

        dfs(1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(distance[u] + distance[v] - 2 * distance[lca(u, v)]).append('\n');
        }

        System.out.print(sb.toString());
    }

    static void dfs(int node, int dist) {
        visited[node] = true;
        distance[node] = dist;

        for (Pair next : tree[node]) {
            if (!visited[next.node]) {
                dfs(next.node, dist + next.weight);
            }
        }
    }

    static int lca(int u, int v) {
        boolean[] visited = new boolean[distance.length];
        while (u > 0) {
            visited[u] = true;
            u = getParent(u);
        }
        while (v > 0) {
            if (visited[v]) {
                return v;
            }
            v = getParent(v);
        }
        return 1;
    }

    static int getParent(int node) {
        for (Pair pair : tree[node]) {
            if (distance[pair.node] < distance[node]) {
                return pair.node;
            }
        }
        return 0;
    }
}