import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();
        
        int i = 0, count = 0;
        while (i <= doc.length() - word.length()) {
            if (doc.substring(i, i + word.length()).equals(word)) {
                count++;
                i += word.length();
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}
