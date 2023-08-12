import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();

        while(N > 0) {
            int remainder = N % B;
            if(remainder < 10) {
                sb.append(remainder);
            } else {
                char ch = (char)('A' + (remainder - 10));
                sb.append(ch);
            }
            N /= B;
        }

        System.out.println(sb.reverse().toString());
    }
}