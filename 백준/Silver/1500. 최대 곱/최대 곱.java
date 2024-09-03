import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = s / k;
        }
        
        int remainder = s % k;
        for (int i = 0; i < remainder; i++) {
            arr[i]++;
        }
        
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= arr[i];
        }
        
        System.out.println(result);
    }
}