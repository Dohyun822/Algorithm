import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.length() == 1) {
            System.out.println("NO");
            return;
        }

        boolean isEugeneNumber = false;
        for (int i = 1; i < s.length(); i++) {
            String leftPart = s.substring(0, i);
            String rightPart = s.substring(i);

            long productLeft = digitProduct(leftPart);
            long productRight = digitProduct(rightPart);

            if (productLeft == productRight) {
                isEugeneNumber = true;
                break;
            }
        }

        System.out.println(isEugeneNumber ? "YES" : "NO");
    }

    private static long digitProduct(String str) {
        long product = 1;
        for (char c : str.toCharArray()) {
            product *= c - '0';
        }
        return product;
    }
}