import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] per = new int[10];
    static boolean[] visit = new boolean[10];
    static int[][] arr = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        permutation(0);
    }

    static void permutation(int depth) {
        if (depth == N) {
            if (solve()) {
                for (int i = 0; i < N; i++) System.out.print(per[i] + " ");
                System.exit(0);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                per[depth] = i + 1;
                permutation(depth + 1);
                visit[i] = false;
            }
        }
    }

    static boolean solve() {
        for (int i = 0; i < N; i++) arr[0][i] = per[i];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j + 1];
            }
        }
        return arr[N - 1][0] == M;
    }
}