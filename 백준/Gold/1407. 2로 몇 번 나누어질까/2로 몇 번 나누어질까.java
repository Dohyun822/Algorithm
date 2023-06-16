import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long start;
    private static long end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());

        // 'f(end) - f(start - 1)'를 통해 start부터 end까지 각 숫자를 2로 나눌 수 있는 횟수의 합을 구한다.
        System.out.println(computeSum(end) - computeSum(start - 1));
    }

    private static long computeSum(long num) {
        long totalSum = num; // 최종 합계를 저장할 변수. num이 주어진 숫자 자체를 포함하므로 초기화는 num으로 한다.
        long divisor = 2; // 나눗셈에 사용될 숫자. 2, 4, 8, 16, ... 순서로 증가한다.

        while (divisor <= num) {
            totalSum += (num / divisor) * (divisor / 2);
            divisor *= 2;
        }
        
        return totalSum;
    }
}