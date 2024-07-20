import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger sum = BigInteger.ZERO;

        for (int i = 1; i < N; i++) {
            BigInteger current = BigInteger.valueOf((long) i * N + i);
            sum = sum.add(current);
        }

        System.out.println(sum);
    }
}