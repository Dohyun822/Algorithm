import java.util.*;
import java.io.*;

public class Main {
    private static int[] parent;
    private static int[] size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            HashMap<String, Integer> people = new HashMap<>();
            parent = new int[2 * F];
            size = new int[2 * F];

            for (int i = 0; i < 2 * F; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            int id = 0;
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String person1 = st.nextToken();
                String person2 = st.nextToken();

                if (!people.containsKey(person1)) {
                    people.put(person1, id++);
                }
                if (!people.containsKey(person2)) {
                    people.put(person2, id++);
                }

                int root1 = find(people.get(person1));
                int root2 = find(people.get(person2));

                if (root1 != root2) {
                    union(root1, root2);
                }

                sb.append(size[find(root1)]).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}
