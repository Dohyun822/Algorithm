import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer[] P = new Integer[M];

        for (int i = 0; i < M; i++) {
            P[i] = Integer.parseInt(br.readLine());
        }

        // 고객이 지불할 수 있는 금액을 내림차순으로 정렬
        Arrays.sort(P, Collections.reverseOrder());

        int bestPrice = 0;
        long maxRevenue = 0;

        for (int i = 0; i < Math.min(M, N); i++) {
            long revenue = (long) P[i] * (i + 1);
            if (revenue > maxRevenue) {
                maxRevenue = revenue;
                bestPrice = P[i];
            }
        }

        System.out.println(bestPrice + " " + maxRevenue);
    }
}