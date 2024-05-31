import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static String S;
    private final static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = br.readLine();

        long[] W = new long[N + 1];
        long[] WH = new long[N + 1];
        long[] WHE = new long[N + 1];
        long[] WHEE = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            char temp = S.charAt(i - 1);
            W[i] = W[i - 1];
            WH[i] = WH[i - 1];
            WHE[i] = WHE[i - 1];
            WHEE[i] = WHEE[i - 1];

            if (temp == 'W') {
                W[i] = (W[i] + 1) % MOD;
            } else if (temp == 'H') {
                WH[i] = (WH[i] + W[i - 1]) % MOD;
            } else if (temp == 'E') {
                WHEE[i] = (WHEE[i] * 2 + WHE[i - 1]) % MOD;
                WHE[i] = (WHE[i] + WH[i - 1]) % MOD;
            }
        }

        System.out.println(WHEE[N]);
    }
}