import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        int d = a[1] - a[0];
        int r = a[1] / a[0];
        
        boolean arith = true;
        boolean geom = true;
        
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] != d) {
                arith = false;
            }
            if (a[i] / a[i - 1] != r) {
                geom = false;
            }
        }
        
        int next = 0;
        if (arith) {
            next = a[n - 1] + d;
        } else if (geom) {
            next = a[n - 1] * r;
        }
        
        System.out.println(next);
    }
}