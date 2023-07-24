import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] grid = new int[9][9];

        // 격자판 입력 받기
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxVal = Integer.MIN_VALUE;
        int row = -1, col = -1;

        // 최댓값과 그 위치 찾기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                    row = i + 1; // 행과 열은 1부터 시작이므로 +1
                    col = j + 1;
                }
            }
        }

        // 결과 출력을 위한 StringBuilder 생성
        StringBuilder sb = new StringBuilder();
        sb.append(maxVal).append("\n");
        sb.append(row).append(" ").append(col);

        // 결과 출력
        System.out.println(sb.toString());
    }
}