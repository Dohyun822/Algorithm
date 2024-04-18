import java.io.*;
import java.util.*;

public class Main {
    private static String answer = "";
    private static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        B = Integer.parseInt(st.nextToken());

        char[] chars = A.toCharArray();
        boolean[] visited = new boolean[A.length()];
        
        permutation("", chars, visited);

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void permutation(String current, char[] chars, boolean[] visited) {
        if (current.length() == chars.length) {
            int num = Integer.parseInt(current);
            if (num < B) {
                if (answer.isEmpty() || Integer.parseInt(answer) < num) {
                    answer = current;
                }
            }
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                if (chars[i] == '0' && current.isEmpty()) continue;
                visited[i] = true;
                permutation(current + chars[i], chars, visited);
                visited[i] = false;
            }
        }
    }
}