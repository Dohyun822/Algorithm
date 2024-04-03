import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int total = 0;

        for (int i = 0; i < N; i++) {
            total += Integer.parseInt(br.readLine());
        }

        System.out.println(total - N + 1);
    }
}
