import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 진짜 약수의 개수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            int divisor = Integer.parseInt(st.nextToken());
            if(divisor < min) {
                min = divisor;
            }
            if(divisor > max) {
                max = divisor;
            }
        }

        System.out.println(min * max); // N을 출력
    }
}