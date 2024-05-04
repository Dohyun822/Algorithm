import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        if (m + T > M) {
            System.out.println(-1);
            return;
        }
        
        int cur = m;
        int min = 0;
        int time = 0;

        while (time < N) {
            if (cur + T <= M) {
                cur += T;
                time++;
            } else {
                cur = Math.max(cur - R, m);
            }
            min++;
        }

        System.out.println(min);
    }
}