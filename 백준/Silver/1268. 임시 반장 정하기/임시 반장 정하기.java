import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] c = new int[n][5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) c[i][j] = Integer.parseInt(st.nextToken());
        }

        int max = 0, leader = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (c[i][j] == c[k][j] && i != k) s.add(k);
                }
            }
            if (s.size() > max) {
                max = s.size();
                leader = i;
            }
        }
        System.out.println(leader + 1);
    }
}
