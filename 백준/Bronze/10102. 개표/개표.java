import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        String s = sc.next();
        int a = 0, b = 0;
        for (int i = 0; i < v; i++) {
            if (s.charAt(i) == 'A') a++;
            else b++;
        }
        if (a > b) System.out.println("A");
        else if (b > a) System.out.println("B");
        else System.out.println("Tie");
    }
}
