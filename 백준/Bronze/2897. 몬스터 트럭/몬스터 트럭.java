import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        char[][] p = new char[r][c];
        for (int i = 0; i < r; i++) {
            p[i] = br.readLine().toCharArray();
        }
        
        int[] res = new int[5];
        
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c - 1; j++) {
                int x = 0;
                
                if (p[i][j] == '#' || p[i+1][j] == '#' || p[i][j+1] == '#' || p[i+1][j+1] == '#') {
                    continue;
                }
                
                if (p[i][j] == 'X') x++;
                if (p[i+1][j] == 'X') x++;
                if (p[i][j+1] == 'X') x++;
                if (p[i+1][j+1] == 'X') x++;
                
                res[x]++;
            }
        }
        
        for (int i = 0; i < 5; i++) {
            System.out.println(res[i]);
        }
    }
}