import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];
        String input;

        while ((input = br.readLine()) != null) {
            for (char c : input.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    alphabet[c - 'a']++;
                }
            }
        }

        int max = 0;
        for (int freq : alphabet) {
            if (freq > max) {
                max = freq;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == max) {
                result.append((char) (i + 'a'));
            }
        }

        System.out.println(result);
    }
}