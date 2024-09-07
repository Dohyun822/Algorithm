import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        double blaster = 350.34;
        double visualSensor = 230.90;
        double audioSensor = 190.55;
        double arm = 125.30;
        double leg = 180.90;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            double totalCost = a * blaster + b * visualSensor + c * audioSensor + d * arm + e * leg;
            sb.append(String.format("$%.2f\n", totalCost));
        }
        System.out.print(sb);
    }
}