import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] sides = new int[4];
        for (int i = 0; i < 4; i++) {
            sides[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(sides);
        
        int maxArea = sides[0] * sides[2];
        System.out.println(maxArea);
    }
}
