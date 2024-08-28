import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        int totalLength = (L + 5) * N - 5;
        int time = 0;

        while (time <= totalLength) {
            if (time % (L + 5) >= L) {
                System.out.println(time);
                return;
            }
            time += D;
        }
        
        System.out.println(time);
    }
}
