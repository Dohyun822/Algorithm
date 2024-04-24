import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long comb(int n, int r) {
        long c = 1;
        long p = 1;
        while (r > 0) {
            c *= n--;
            p *= r--;
        }
        return c / p;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double res = 0.0;
        double p = comb(N, M);
        while (M >= K) {
            if (N - M < M - K) {
                K++;
                continue;
            }
            double c = comb(M, K) * comb(N - M, M - K);
            res += c / p;
            K++;
        }
        
        System.out.printf("%.16f\n", res);
    }
}