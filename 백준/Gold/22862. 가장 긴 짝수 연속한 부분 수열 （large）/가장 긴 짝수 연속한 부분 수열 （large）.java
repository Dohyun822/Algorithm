import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] s = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(solve(n, k, s));
    }
    
    private static int solve(int n, int k, int[] s) {
        int a = 0;
        int b = 0;
        int answer = 0;
        int c = 0;
        
        while (b < n) {
            if (s[b] % 2 != 0) {
                c++;
            }
            
            while (c > k) {
                if (s[a] % 2 != 0) {
                    c--;
                }
                a++;
            }
            
            answer = Math.max(answer, b - a + 1 - c);
            b++;
        }
        
        return answer;
    }
}