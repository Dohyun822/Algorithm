import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        long k = 1;
        long time = 0;
        
        while (n > 0) {
            if (n < k) {
                k = 1;
            }
            n -= k;
            k++;
            time++;
        }
        
        System.out.println(time);
    }
}