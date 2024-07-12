import java.util.*;
import java.io.*;

public class Main {


    private static class Info {
        int idx;
        int cost;

        public Info(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    private static int N;
    private static int[] cost;
    private static ArrayList<Info>[] sale;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        sale = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            sale[i] = new ArrayList<Info>();

        }

        for (int i = 1; i <= N; i++) {
            int T = Integer.parseInt(br.readLine());

            for (int j = 0; j < T; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int idx = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                sale[i].add(new Info(idx, cost));
            }
        }

        visited = new boolean[N + 1];
        answer = Integer.MAX_VALUE;
        recur(0, 0);


        System.out.println(answer);
    }

    private static void recur(int cnt, int hap) {
        if (cnt == N) {
            answer = Math.min(answer, hap);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int[] temp = cost.clone();

                for (Info info : sale[i]) {
                    cost[info.idx] = Math.max(1, cost[info.idx] - info.cost);
                }

                recur(cnt + 1, hap + cost[i]);

                cost = temp;
                visited[i] = false;
            }
        }
    }
}