import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        double k = Math.sqrt((double) D * D / (H * H + W * W));
        
        int height = (int) (H * k);
        int width = (int) (W * k);
        
        System.out.println(height + " " + width);
    }
}