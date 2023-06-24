import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] house = new int[N];
            for (int i = 0; i < N; i++) {
                house[i] = Integer.parseInt(st.nextToken());
            }

            long[] circleHouseSum = new long[N * 2 + 1];
            for (int i = 1; i < circleHouseSum.length; i++) {
                circleHouseSum[i] = circleHouseSum[i - 1] + house[(i - 1) % N];
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                if (circleHouseSum[i + M] - circleHouseSum[i] < K) {
                    answer++;
                }
                if (N == M) break;
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}