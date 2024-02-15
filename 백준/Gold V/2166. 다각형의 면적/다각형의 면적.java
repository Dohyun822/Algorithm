import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] x = new long[N];
        long[] y = new long[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        
        long area = 0;
        for (int i = 0; i < N - 1; i++) {
            area += x[i] * y[i + 1] - y[i] * x[i + 1];
        }
        area += x[N - 1] * y[0] - y[N - 1] * x[0];
        
        double result = Math.abs(area) / 2.0;
        System.out.printf("%.1f\n", result);
    }
}