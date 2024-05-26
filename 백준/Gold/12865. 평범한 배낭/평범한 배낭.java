import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int K;
    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            for (int w = 0; w <= K; w++) {
                if (w - arr[i][0] >= 0) {
                    dp[i + 1][w] = Math.max(dp[i][w], dp[i][w - arr[i][0]] + arr[i][1]);
                } else {
                    dp[i + 1][w] = dp[i][w];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}