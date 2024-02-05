import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, String> sitePasswords = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sitePasswords.put(st.nextToken(), st.nextToken());
        }
        
        for(int i = 0; i < M; i++) {
            sb.append(sitePasswords.get(br.readLine())).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
