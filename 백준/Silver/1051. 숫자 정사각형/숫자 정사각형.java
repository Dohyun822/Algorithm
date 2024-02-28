import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int maxSide = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int side = maxSide; side < Math.min(N, M); side++) {
                    if(i + side < N && j + side < M) {
                        if(map[i][j] == map[i + side][j] && map[i][j] == map[i][j + side] && map[i][j] == map[i + side][j + side]) {
                            maxSide = Math.max(maxSide, side + 1);
                        }
                    }
                }
            }
        }

        System.out.println(maxSide * maxSide);
    }
}