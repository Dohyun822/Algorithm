import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int K;
    private static boolean[] isPrime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isPrime = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= N; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        cnt++;
                        if (cnt == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}
