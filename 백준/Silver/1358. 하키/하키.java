import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int R = H / 2;
        int count = 0;
        
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());
            
            if (px >= X && px <= X + W && py >= Y && py <= Y + H) {
                count++;
            } else if (Math.pow(px - X, 2) + Math.pow(py - (Y + R), 2) <= Math.pow(R, 2)) {
                count++;
            } else if (Math.pow(px - (X + W), 2) + Math.pow(py - (Y + R), 2) <= Math.pow(R, 2)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
