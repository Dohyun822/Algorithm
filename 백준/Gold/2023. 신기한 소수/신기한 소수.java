import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] primes = new int[]{2, 3, 5, 7};

        for (int prime : primes) {
            solve(prime, 1, N);
        }

    }

    private static void solve(int curN, int curL, int N) {
        if (curL == N) {
            System.out.println(curN);
            return;
        }

        for (int i = 1; i < 10; i++) {
            int nextNum = curN * 10 + i;
            if (isPrime(nextNum)) {
                solve(nextNum, curL + 1, N);
            }

        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}