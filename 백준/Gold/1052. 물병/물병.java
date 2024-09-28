import java.io.*;
import java.util.*;

public class Main {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        int ans = 0;

        while (Integer.bitCount(n) > k) {
            ans += n & (-n);
            n += n & (-n);
        }
        System.out.println(ans);
    }
}
