import java.io.*;

public class Main {
    
    public static boolean checkPerfectSquare(int x) {
        int sqrtX = (int) Math.sqrt(x);
        return sqrtX * sqrtX == x;
    }

    public static boolean checkSumOfTwoSquares(int x) {
        for (int i = 1; i * i <= x; i++) {
            if (checkPerfectSquare(x - i * i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (checkPerfectSquare(n)) {
            System.out.println(1);
            return;
        }

        if (checkSumOfTwoSquares(n)) {
            System.out.println(2);
            return;
        }

        for (int i = 1; i * i <= n; i++) {
            if (checkSumOfTwoSquares(n - i * i)) {
                System.out.println(3);
                return;
            }
        }

        System.out.println(4);
    }
}