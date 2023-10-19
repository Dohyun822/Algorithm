import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        
        int answer = -1;
        for (int i = 1; T > 0; i++) {
            for (int j = 0; T > 0 && j < 4; j++) {
                T -= (j % 2 == B ? 1 : 0);
                ++answer;
            }
            for (int j = 0; T > 0 && j < 2; j++) {
                for (int k = 0; T > 0 && k <= i; k++) {
                    T -= (j % 2 == B ? 1 : 0);
                    ++answer;
                }
            }
        }
        
        System.out.println(answer % A);
    }
}
