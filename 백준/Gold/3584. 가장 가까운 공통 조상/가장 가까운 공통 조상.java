import java.util.*;
import java.io.*;

public class Main {
    private static int T;
    private static int N;
    private static ArrayList<Integer>[] graphs;
    private static int[] parent;
    private static int[] depth;

    public static void main(String[] ars) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());

            graphs = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                graphs[j] = new ArrayList<>();
            }

            boolean[] isChild = new boolean[N + 1];

            for (int j = 0; j < N - 1; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                graphs[A].add(B);
                graphs[B].add(A);
                isChild[B] = true;
            }

            parent = new int[N + 1];
            depth = new int[N + 1];

            int root = 1;
            for (int j = 1; j <= N; j++) {
                if (!isChild[j]) {
                    root = j;
                    break;
                }
            }

            dfs(root, 0);

            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(getAnswer(a, b));
        }

    }

    private static int getAnswer(int a, int b) {
        while (depth[a] > depth[b]) {
            a = parent[a];
        }
        while (depth[b] > depth[a]) {
            b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    private static void dfs(int cur, int prev) {
        for (Integer i : graphs[cur]) {
            if (i != prev) {
                parent[i] = cur;
                depth[i] = depth[cur] + 1;
                dfs(i, cur);
            }
        }
    }
}
