import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 구매한 주스의 양 A, B, C 입력
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        
        // 칵테일 비율 I, J, K 입력
        double i = sc.nextDouble();
        double j = sc.nextDouble();
        double k = sc.nextDouble();
        
        // 칵테일을 만들 수 있는 최대 횟수를 계산
        double t = Math.min(a / i, Math.min(b / j, c / k));
        
        // 남은 주스 양 계산
        double remainingA = a - i * t;
        double remainingB = b - j * t;
        double remainingC = c - k * t;
        
        // 결과 출력 (소수점 6자리까지)
        System.out.printf("%.6f %.6f %.6f\n", remainingA, remainingB, remainingC);
        
        sc.close();
    }
}