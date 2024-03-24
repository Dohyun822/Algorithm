import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int maxLen = 0;

        for (int len = 2; len <= s.length(); len += 2) {
            for (int start = 0; start <= s.length() - len; start++) {
                int end = start + len;
                String sub = s.substring(start, end);
                int leftSum = 0, rightSum = 0;

                for (int i = 0; i < sub.length() / 2; i++) {
                    leftSum += sub.charAt(i) - '0';
                    rightSum += sub.charAt(i + sub.length() / 2) - '0';
                }

                if (leftSum == rightSum) {
                    maxLen = len;
                }
            }
        }

        System.out.println(maxLen);
    }
}