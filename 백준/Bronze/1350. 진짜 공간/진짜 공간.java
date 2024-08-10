import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int c = Integer.parseInt(br.readLine());
        
        long total = 0;
        
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(arr[i]);
            total += ((size + c - 1) / c) * c;
        }
        
        System.out.println(total);
    }
}