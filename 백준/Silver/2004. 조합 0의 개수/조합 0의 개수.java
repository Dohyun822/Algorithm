import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long countTwo = countFactors(n, 2) - countFactors(m, 2) - countFactors(n - m, 2);
        long countFive = countFactors(n, 5) - countFactors(m, 5) - countFactors(n - m, 5);

        long zeroCount = Math.min(countTwo, countFive);
        System.out.println(zeroCount);
    }

    private static long countFactors(long num, int factor) {
        long count = 0;
        for (long i = factor; i <= num; i *= factor) {
            count += num / i;
        }
        return count;
    }
}
