import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int min = a, mid = b, max = c;
        
        if (min > mid) {
            int temp = min;
            min = mid;
            mid = temp;
        }
        
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        
        if (mid > max) {
            int temp = mid;
            mid = max;
            max = temp;
        }
        
        System.out.println(min + " " + mid + " " + max);
    }
}