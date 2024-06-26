import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String password = br.readLine();
            int length = password.length();
            
            if (length >= 6 && length <= 9) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}