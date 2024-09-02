import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int factor = 10;

        while (n >= factor) {
            n = (n + factor / 2) / factor * factor;
            factor *= 10;
        }

        System.out.println(n);
    }
}
