import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        String road = br.readLine();

        int answer = 0;
        int black = 0;
        int white = 0;
        int start = 0;
        int end = 0;

        while (end < N) {
            if (road.charAt(end) == 'B') {
                black++;
            } else if (road.charAt(end) == 'W') {
                white++;
            }

            while (black > B) {
                if (road.charAt(start) == 'B') {
                    black--;
                } else if (road.charAt(start) == 'W') {
                    white--;
                }
                start++;
            }

            if (white >= W) {
                answer = Math.max(answer, end - start + 1);
            }

            end++;

        }

        System.out.println(answer);
    }
}
