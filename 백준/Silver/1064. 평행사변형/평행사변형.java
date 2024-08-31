import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] p = new int[6];
        for (int i = 0; i < 6; i++) p[i] = Integer.parseInt(st.nextToken());

        if ((p[2] - p[0]) * (p[5] - p[1]) == (p[4] - p[0]) * (p[3] - p[1])) {
            System.out.println(-1);
            return;
        }

        double a = len(p[0], p[1], p[2], p[3]);
        double b = len(p[2], p[3], p[4], p[5]);
        double c = len(p[4], p[5], p[0], p[1]);

        double mx = Math.max(a, Math.max(b, c));
        double mn = Math.min(a, Math.min(b, c));

        System.out.println(2 * (mx - mn));
    }

    static double len(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}