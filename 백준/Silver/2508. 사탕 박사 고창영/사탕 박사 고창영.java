import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            char[][] matrix = new char[r][c];
            
            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
            
            int count = 0;
            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (j + 2 < c && matrix[i][j] == '>' && matrix[i][j + 1] == 'o' && matrix[i][j + 2] == '<') {
                        count++;
                    }
                    if (i + 2 < r && matrix[i][j] == 'v' && matrix[i + 1][j] == 'o' && matrix[i + 2][j] == '^') {
                        count++;
                    }
                }
            }
            
            System.out.println(count);
        }
    }
}