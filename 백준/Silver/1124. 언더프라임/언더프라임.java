import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isPrime = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 0;

        generatePrimes();

        for (int i = A; i <= B; i++) {
            int factorCount = countFactors(i);
            if (isPrime[factorCount]) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void generatePrimes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static int countFactors(int number) {
        int count = 0;
        for (int i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                count++;
                number /= i;
            }
        }
        if (number > 1) {
            count++;
        }
        return count;
    }
}