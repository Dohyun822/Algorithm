import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int seconds = 0;
        int K = 1;

        while (N > 0) {
            if (N < K) {
                K = 1;
            }
            N -= K;
            K++;
            seconds++;
        }
        System.out.println(seconds);
    }
}