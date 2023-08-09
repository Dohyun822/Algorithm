import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] subtreeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        subtreeSize = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[U].add(V);
            graph[V].add(U);
        }

        dfs(R, -1);  // root and its parent

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[u]).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void dfs(int node, int parent) {
        subtreeSize[node] = 1;
        for (int child : graph[node]) {
            if (child != parent) {
                dfs(child, node);
                subtreeSize[node] += subtreeSize[child];
            }
        }
    }
}
