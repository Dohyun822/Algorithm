import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if (d == 0 && m == 0 && y == 0) break;
            
            if (isLeapYear(y)) days[1] = 29;
            else days[1] = 28;
            
            int total = 0;
            for (int i = 0; i < m - 1; i++) {
                total += days[i];
            }
            total += d;
            
            System.out.println(total);
        }
    }

    static boolean isLeapYear(int y) {
        if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) return true;
        return false;
    }
}
