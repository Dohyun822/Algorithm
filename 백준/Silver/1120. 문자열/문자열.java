import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String A = st.nextToken();
        String B = st.nextToken();

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            sb.setLength(0);
            for (int j = 0; j < i; j++) {
                sb.append(B.charAt(j));
            }
            sb.append(A);

            for (int j = A.length() + i; j < B.length(); j++) {
                sb.append(B.charAt(j));
            }

            int diff = 0;
            for (int j = 0; j < B.length(); j++) {
                if (sb.charAt(j) != B.charAt(j)) {
                    diff++;
                }
            }
            minDiff = Math.min(minDiff, diff);
        }
        System.out.println(minDiff);
    }
}