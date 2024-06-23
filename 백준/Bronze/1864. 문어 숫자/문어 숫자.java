import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals("#")) {
            System.out.println(convertOctopusToDecimal(input));
        }
    }

    private static int convertOctopusToDecimal(String octopusNumber) {
        int decimalValue = 0;
        int base = 8;
        int length = octopusNumber.length();

        for (int i = 0; i < length; i++) {
            char c = octopusNumber.charAt(i);
            int value = getOctopusDigitValue(c);
            decimalValue = decimalValue * base + value;
        }

        return decimalValue;
    }

    private static int getOctopusDigitValue(char c) {
        switch (c) {
            case '-': return 0;
            case '\\': return 1;
            case '(': return 2;
            case '@': return 3;
            case '?': return 4;
            case '>': return 5;
            case '&': return 6;
            case '%': return 7;
            case '/': return -1;
            default: throw new IllegalArgumentException("Invalid octopus digit: " + c);
        }
    }
}