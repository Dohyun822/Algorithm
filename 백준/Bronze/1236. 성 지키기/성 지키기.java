import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        
        boolean[] rowCheck = new boolean[N]; // 각 행에 경비원이 있는지 체크
        boolean[] colCheck = new boolean[M]; // 각 열에 경비원이 있는지 체크
        int rowCount = 0; // 경비원이 없는 행의 수
        int colCount = 0; // 경비원이 없는 열의 수
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'X') {
                    rowCheck[i] = true;
                    colCheck[j] = true;
                }
            }
        }
        
        for (boolean r : rowCheck) {
            if (!r) rowCount++;
        }
        for (boolean c : colCheck) {
            if (!c) colCount++;
        }
        
        System.out.println(Math.max(rowCount, colCount));
    }
}