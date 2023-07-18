import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++)
                System.out.print(" ");
            for (int j = 0; j < 2 * i + 1; j++)
                System.out.print("*");
            System.out.println();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(" ");
            for (int j = 0; j < 2 * (N - i - 1) - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}