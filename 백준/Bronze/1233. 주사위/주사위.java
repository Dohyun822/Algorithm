import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());
        
        int[] hap = new int[S1 + S2 + S3 + 1];
        
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    hap[i + j + k]++;
                }
            }
        }
        
        int max = 0;
        int result = 0;
        
        for (int i = 3; i < hap.length; i++) {
            if (hap[i] > max) {
                max = hap[i];
                result = i;
            }
        }
        
        System.out.println(result);
    }
}