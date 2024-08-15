import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String input = br.readLine();
            int n = Integer.parseInt(input);
            
            if (n == 0) break;
            
            while (n >= 10) {
                int sum = 0;
                while (n > 0) {
                    sum += n % 10;
                    n /= 10;
                }
                n = sum;
            }
            
            System.out.println(n);
        }
    }
}