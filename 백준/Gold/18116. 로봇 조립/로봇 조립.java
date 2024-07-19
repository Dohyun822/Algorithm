import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] parent;
    private static int[] rank;
    private static int[] size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        parent = new int[1000001];
        rank = new int[1000001];
        size = new int[1000001];

        for (int i = 1; i <= 1000000; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else if (command.equals("Q")) {
                int a = Integer.parseInt(st.nextToken());
                int rootA = find(a);
                sb.append(size[rootA]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else if (rank[rootB] < rank[rootA]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
            rank[rootA]++;
        }
    }

    private static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}
