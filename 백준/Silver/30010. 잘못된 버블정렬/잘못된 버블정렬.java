import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = N; i > 0; i--) {
            sb.append(i);
            if (i > 1) {
                sb.append(" ");
            }
        }

        System.out.print(sb);
    }
}