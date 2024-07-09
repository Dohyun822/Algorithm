import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static ArrayList<Integer>[] graphs;
    private static int[] parent;

    public static void main(String[] ars) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graphs = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graphs[s].add(t);
            graphs[t].add(s);

        }

        parent = new int[N + 1];

        dfs(1, 0);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int cur, int prev) {
        for (Integer i : graphs[cur]) {
            if (i == prev) {
                continue;
            }
            parent[i] = cur;
            dfs(i, cur);
        }
    }
}