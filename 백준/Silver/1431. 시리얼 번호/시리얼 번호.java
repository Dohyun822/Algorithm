import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] serials = new String[N];

        for (int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    int sum1 = sumDigits(s1);
                    int sum2 = sumDigits(s2);
                    if (sum1 != sum2) {
                        return sum1 - sum2;
                    } else {
                        return s1.compareTo(s2);
                    }
                }
            }

            private int sumDigits(String s) {
                int sum = 0;
                for (char c : s.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sum += c - '0';
                    }
                }
                return sum;
            }
        });

        for (String serial : serials) {
            System.out.println(serial);
        }
    }
}