import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            ArrayList<Integer> divisors = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                    sum += i;
                }
            }

            if (sum == n) {
                System.out.print(n + " = ");
                for (int i = 0; i < divisors.size(); i++) {
                    System.out.print(divisors.get(i));
                    if (i < divisors.size() - 1) {
                        System.out.print(" + ");
                    }
                }
                System.out.println();
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}
