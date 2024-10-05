import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sangduk = sc.nextInt();
        int jungduk = sc.nextInt();
        int haduk = sc.nextInt();
        int cola = sc.nextInt();
        int cider = sc.nextInt();

        int burgerMin = Math.min(sangduk, Math.min(jungduk, haduk));
        int drinkMin = Math.min(cola, cider);

        int cheapestSetPrice = burgerMin + drinkMin - 50;
        System.out.println(cheapestSetPrice);
    }
}