import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            
            if (N > 32) {
                sb.append(0).append('\n');
            } else {
                int result = Integer.MAX_VALUE;
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        for (int k = j + 1; k < N; k++) {
                            int distance = distance(inputs[i], inputs[j]) + distance(inputs[i], inputs[k]) + distance(inputs[j], inputs[k]);
                            result = Math.min(result, distance);
                        }
                    }
                }
                sb.append(result).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
    
    public static int distance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}