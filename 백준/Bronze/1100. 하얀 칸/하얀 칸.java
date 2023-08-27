import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        
        for (int i = 0; i < 8; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                // 하얀 칸을 체크할 조건
                if ((i + j) % 2 == 0) {
                    if (row.charAt(j) == 'F') {
                        count++;
                    }
                }
            }
        }
        
        sc.close();
        
        System.out.println(count);
    }
}