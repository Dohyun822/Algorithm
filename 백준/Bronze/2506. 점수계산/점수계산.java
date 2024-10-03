import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int b = 0;
        int c = 0;
        
        for (int i = 0; i < a; i++) {
            if (st.nextToken().equals("1")) {
                c++;
                b += c;
            } else {
                c = 0;
            }
        }
        
        System.out.println(b);
    }
}
